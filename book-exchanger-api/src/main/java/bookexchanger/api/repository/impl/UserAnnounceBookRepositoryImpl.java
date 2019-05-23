package bookexchanger.api.repository.impl;

import bookexchanger.api.ConnectionManager;
import bookexchanger.api.entities.BookEntity;
import bookexchanger.api.entities.UserAnnounceBookEntity;
import bookexchanger.api.entities.UserEntity;
import bookexchanger.api.repository.UserAnnounceBookRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserAnnounceBookRepositoryImpl implements UserAnnounceBookRepository {

    private static final String SELECT_ALL = " SELECT\n" +
            "a.id AS announce_id,\n" +
            "a.user_id,\n" +
            "a.book_id,\n" +
            "a.announce_timestamp,\n" +
            "a.is_active\n AS announce_is_active," +
            "u.first_name,\n" +
            "u.surname,\n" +
            "u.email,\n" +
            "u.phone,\n" +
            "u.password,\n" +
            "u.is_active,\n" +
            "b.name,\n" +
            "b.genre,\n" +
            "b.description,\n" +
            "b.author,\n" +
            "b.year\n" +
            "FROM public.announce_board a " +
            "JOIN  public.\"user\" u ON a.user_id = u.id " +
            "JOIN  public.\"book\" b ON a.book_id = b.id";


    private static final String FIND_BY_ID = SELECT_ALL + " WHERE u.id=?";

    @Override
    public List<UserAnnounceBookEntity> selectAll() {
        List<UserAnnounceBookEntity> entities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                entities.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public UserAnnounceBookEntity findById(Integer _id) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)) {
            statement.setInt(1, _id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return parseResultSet(resultSet);
            }

        }
        return null;

    }
    private UserAnnounceBookEntity parseResultSet(ResultSet rs) throws SQLException {

        UserAnnounceBookEntity entity = new UserAnnounceBookEntity();
        entity.setId(rs.getInt("announce_id"));

        UserEntity userEntity = new UserEntity();
        userEntity.setId(rs.getInt("user_id"));
        userEntity.setFirstName(rs.getString("first_name"));
        userEntity.setSurname(rs.getString("surname"));
        userEntity.setEmail(rs.getString("email"));
        userEntity.setPhone(rs.getString("phone"));
        userEntity.setPassword(rs.getString("password"));
        userEntity.setActive(rs.getBoolean("is_active"));
        entity.setUserEntity(userEntity);

        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(rs.getInt("book_id"));
        bookEntity.setName(rs.getString("name"));
        bookEntity.setGenre(rs.getString("genre"));
        bookEntity.setDescription(rs.getString("description"));
        bookEntity.setAuthor(rs.getString("author"));
        bookEntity.setYear(rs.getDate("year").toLocalDate());
        entity.setBookEntity(bookEntity);
        entity.setActive(rs.getBoolean("announce_is_active"));
        entity.setAnnounceTimeStamp(rs.getTimestamp("announce_timestamp").toLocalDateTime());

        return entity;
    }


    public static void main(String[] args) throws SQLException {
        UserAnnounceBookRepositoryImpl  userAnnounceBookRepository = new UserAnnounceBookRepositoryImpl();
        System.out.println(userAnnounceBookRepository.findById(3));
    }


}

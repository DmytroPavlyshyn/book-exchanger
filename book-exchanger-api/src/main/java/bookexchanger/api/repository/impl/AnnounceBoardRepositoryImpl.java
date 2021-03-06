package bookexchanger.api.repository.impl;

import bookexchanger.api.ConnectionManager;
import bookexchanger.api.entities.AnnounceBoardEntity;
import bookexchanger.api.repository.AnnounceBoardRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnnounceBoardRepositoryImpl implements AnnounceBoardRepository {
    private static final String SELECT_ALL = "SELECT * FROM public.announce_board";


    private static final String CREATE =
            "INSERT INTO public.announce_board (\"user_id\",\"book_id\",\"announce_timestamp\",\"is_active\") VALUES(?,?,?,?) RETURNING id";

    public static void main(String[] args) throws SQLException {
        new AnnounceBoardRepositoryImpl()
                .selectAll()
                .stream()
                .filter((s) -> s.getActive())
                .forEach(System.out::println);

    }

    @Override
    public AnnounceBoardEntity insert(AnnounceBoardEntity entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE)) {
            setPreparedStatementData(statement, entity);
            try (ResultSet generatedKeys = statement.executeQuery()) {
                if (generatedKeys.next()) {
                    entity.setId(generatedKeys.getInt(1));

                }
            }
        }
        return entity;
    }

    @Override
    public List<AnnounceBoardEntity> selectAll() throws SQLException {
        List<AnnounceBoardEntity> entities = new ArrayList<>();
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
    public AnnounceBoardEntity findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public int update(AnnounceBoardEntity entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(AnnounceBoardEntity entity) throws SQLException {
        return 0;
    }

    private AnnounceBoardEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer userId = resultSet.getInt("user_id");
        Integer bookId = resultSet.getInt("book_id");
        LocalDateTime announceTS = resultSet.getTimestamp("announce_timestamp").toLocalDateTime();
        Boolean isActive = resultSet.getBoolean("is_active");
        return new AnnounceBoardEntity(id, userId, bookId, announceTS, isActive);
    }

    private void setPreparedStatementData(PreparedStatement statement, AnnounceBoardEntity entity) throws SQLException {
        statement.setInt(1, entity.getUserId());
        statement.setInt(2, entity.getBookId());
        statement.setTimestamp(3, Timestamp.valueOf(entity.getAnnounceTimestamp()));
        statement.setBoolean(4, entity.getActive());
    }
}

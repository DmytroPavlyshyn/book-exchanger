package bookexchanger.api.repository.impl;

import bookexchanger.api.ConnectionManager;
import bookexchanger.api.entities.UserEntity;
import bookexchanger.api.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String SELECT_ALL = "SELECT * FROM public.user";
    private static final String FIND_BY_ID = "SELECT * FROM public.user u  WHERE u.id=?";
    private static final String CREATE =
            "INSERT INTO public.user (\"email\",\"password\",\"first_name\",\"surname\",\"phone\",\"is_active\")\n" +
                    "VALUES(?,?,?,?,?,?) RETURNING id;";

    private static final String UPDATE = "UPDATE public.user  u SET  " +
            "\"email\" = ?,\"password\" = ?,\"first_name\" = ?,\"surname\" = ?,\"phone\" = ?,\"is_active\" = ?" +
            "WHERE u.id= ?";
    private static final String DELETE = "DELETE FROM public.user u WHERE u.id = ?";

    @Override
    public List<UserEntity> selectAll() {
        List<UserEntity> userEntities = new ArrayList<>();
        try (
                Connection connection = ConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(SELECT_ALL)
        ) {
            while (resultSet.next()) {
                userEntities.add(parseResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userEntities;
    }

    @Override
    public UserEntity findById(Integer _id) throws SQLException {
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

    @Override
    public UserEntity insert(UserEntity entity) throws SQLException {
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
    public int update(UserEntity entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE)) {
            setPreparedStatementData(statement, entity);
            statement.setInt(7, entity.getId());
            return statement.executeUpdate();
        }
    }

    @Override
    public int delete(UserEntity entity) throws SQLException {
        try (Connection connection = ConnectionManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE)) {
            statement.setInt(1, entity.getId());
            return statement.executeUpdate();
        }
    }

    private UserEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        String firstName = resultSet.getString("first_name");
        String surname = resultSet.getString("surname");
        String phone = resultSet.getString("phone");
        Boolean isActive = resultSet.getBoolean("is_active");
        return new UserEntity(id, email, password, firstName, surname, phone, isActive);
    }

    private void setPreparedStatementData(PreparedStatement statement, UserEntity entity) throws SQLException {
        statement.setString(1, entity.getEmail());
        statement.setString(2, entity.getPassword());
        statement.setString(3, entity.getFirstName());
        statement.setString(4, entity.getSurname());
        statement.setString(5, entity.getPhone());
        statement.setBoolean(6, entity.isActive());
    }

}

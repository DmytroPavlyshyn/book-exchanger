package bookexchanger.api.repository.impl;

import bookexchanger.api.ConnectionManager;
import bookexchanger.api.entities.OrderEntity;
import bookexchanger.api.repository.OrderRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private static final String SELECT_ALL = "SELECT " +
            "\"id\"," +
            "\"announce_id\"," +
            "\"comment\"," +
            "\"is_active\"" +
            " FROM public.order";


    private static final String CREATE =
            "INSERT INTO public.announce_board (\"user_id\",\"book_id\",\"announce_timestamp\",\"is_active\") VALUES(?,?,?,?) RETURNING id";
    @Override
    public List<OrderEntity> selectAll() throws SQLException {
        List<OrderEntity> entities = new ArrayList<>();
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
    public OrderEntity findById(Integer id) throws SQLException {
        return null;
    }

    @Override
    public OrderEntity insert(OrderEntity entity) throws SQLException {
        return null;
    }

    @Override
    public int update(OrderEntity entity) throws SQLException {
        return 0;
    }

    @Override
    public int delete(OrderEntity entity) throws SQLException {
        return 0;
    }

    private OrderEntity parseResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        Integer announceId = resultSet.getInt("announce_id");
        String comment = resultSet.getString("comment");
        Boolean isActive = resultSet.getBoolean("is_active");
        return new OrderEntity(id, announceId, comment, isActive);
    }

    private void setPreparedStatementData(PreparedStatement statement, OrderEntity entity) throws SQLException {
        statement.setInt(1, entity.getId());
        statement.setInt(2, entity.getAnnounceId());
        statement.setString(3, entity.getComment());
        statement.setBoolean(4, entity.getActive());
    }

    public static void main(String[] args) throws SQLException {
        new OrderRepositoryImpl().selectAll().forEach(System.out::println);
    }
}

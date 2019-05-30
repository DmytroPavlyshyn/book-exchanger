package bookexchanger.api.repository;

import bookexchanger.api.entities.OrderEntity;
import bookexchanger.api.models.ClientOrderResponse;

import java.sql.SQLException;
import java.util.List;

public interface OrderRepository extends GeneralRepository<OrderEntity, Integer> {
    List<ClientOrderResponse> findByAnnounceId(Integer _id) throws SQLException;
    int updateStatus(OrderEntity entity) throws SQLException;
}

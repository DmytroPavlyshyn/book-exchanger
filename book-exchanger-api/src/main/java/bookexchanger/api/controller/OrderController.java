package bookexchanger.api.controller;

import bookexchanger.api.entities.OrderEntity;
import bookexchanger.api.entities.UserEntity;
import bookexchanger.api.models.ClientOrderResponse;
import bookexchanger.api.models.OrderApproveRequest;
import bookexchanger.api.models.UserRegRequest;
import bookexchanger.api.models.UserRegResponse;
import bookexchanger.api.repository.OrderRepository;
import bookexchanger.api.repository.impl.UserRepositoryImpl;
import bookexchanger.api.utils.UserTmp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "/api/order")
    public ResponseEntity<List<OrderEntity>> getAllUsers() throws SQLException {
        List<OrderEntity> orderEntities = orderRepository.selectAll();
        return new ResponseEntity<>(orderEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/api/order/{user_id}")
    public ResponseEntity<OrderEntity> getBook(@PathVariable Integer user_id) throws SQLException {
        OrderEntity order = orderRepository.findById(user_id);
        return new ResponseEntity<>(order, HttpStatus.OK);

    }
    @GetMapping(value = "/api/order/announce/{announce_id}")
    public ResponseEntity<List<ClientOrderResponse>> getAnnounce(@PathVariable Integer announce_id) throws SQLException {
        List<ClientOrderResponse> orders = orderRepository.findByAnnounceId(announce_id);
        return new ResponseEntity<>(orders, HttpStatus.OK);

    }
    @PostMapping("/api/order/add")
    public ResponseEntity<OrderEntity> register(@RequestBody OrderEntity regRequest) throws Exception {
        System.out.println(regRequest);
        var reg = orderRepository.insert(new OrderEntity(new UserTmp().getUserId(),
                regRequest.getAnnounceId(),
                regRequest.getComment(),
                true));
        return new ResponseEntity<>(reg, HttpStatus.OK);
    }
    @PostMapping("/api/order/approve/")
    public ResponseEntity<OrderApproveRequest> approveOrder(@RequestBody OrderApproveRequest approveRequest) throws Exception {
        System.out.println(approveRequest);
        var reg = orderRepository.updateStatus(new OrderEntity(approveRequest.getClientId(),
                approveRequest.getAnnounceId(),
                "",
                false));
        return new ResponseEntity<>(approveRequest, HttpStatus.OK);
    }

}

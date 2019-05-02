package bookexchanger.api.controller;

import bookexchanger.api.entities.UserEntity;
import bookexchanger.api.models.UserRegRequest;
import bookexchanger.api.models.UserRegResponse;
import bookexchanger.api.repository.impl.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserRepositoryImpl userRepository;

    @GetMapping(value = "/api/user")
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> userEntities = userRepository.selectAll();
        return new ResponseEntity<>(userEntities, HttpStatus.OK);
    }

    @GetMapping(value = "/api/user/{user_id}")
    public ResponseEntity<UserEntity> getBook(@PathVariable Integer user_id) throws SQLException {
        UserEntity book = userRepository.findById(user_id);
        return new ResponseEntity<>(book, HttpStatus.OK);

    }

    @PostMapping("/api/user/register")
    public ResponseEntity<UserRegResponse> register(@RequestBody UserRegRequest regRequest) throws Exception {

        UserEntity newUser = new UserEntity();
        newUser.setEmail(regRequest.getEmail());
        newUser.setPassword(regRequest.getPassword());
        newUser.setFirstName(regRequest.getFirstName());
        newUser.setSurname(regRequest.getSurname());
        newUser.setPassword(regRequest.getPassword());
        newUser.setPhone(regRequest.getPhone());
        newUser.setActive(true);
        UserEntity insertedUser = this.userRepository.insert(newUser);
        UserRegResponse regResponse = new UserRegResponse();
        regResponse.setUserId(insertedUser.getId());
        return new ResponseEntity<>(regResponse, HttpStatus.OK);
    }

}

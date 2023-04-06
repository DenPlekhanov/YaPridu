package ru.yapridu.aptbooking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yapridu.aptbooking.model.entity.User;
import ru.yapridu.aptbooking.service.UserService;

import java.util.List;

/**
 * @author Den
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@Tag(name = "User", description = "User management")
@ApiResponse(responseCode = "500", description = "Internal error")
//@ApiResponse(responseCode = "400", description = "Validation failed")
@ApiResponse(responseCode = "404", description = "No user was found")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
//    private static final int DEFAULT_PAGINATION_DATA_LIMIT = 10;
//    private static final int DEFAULT_PAGE_NUM = 1;
    private final UserService userService;

    @Operation(description = "Create new user")
    @ApiResponse(responseCode = "201", description = "User was created")
    @PostMapping(value = "", produces = "application/json")
    public ResponseEntity<Long> create(@RequestParam String username,
                                       @RequestParam Integer version) {
        User newUser = User.builder()
                .username(username)
//                .createdDate(Date.from(Instant.now())) //TODO Разобраться с датами
                .version(version)
                .build();
        Long idOfNewUser = userService.createNew(newUser).getId();
        return new ResponseEntity<>(idOfNewUser, HttpStatus.CREATED);
    }

    @Operation(description = "Find all users")
    @ApiResponse(responseCode = "200", description = "Users was found")
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

    @Operation(description = "Find User by Id")
    @ApiResponse(responseCode = "200", description = "User was found")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @Operation(description = "Update user fields")
    @ApiResponse(responseCode = "200", description = "User was updated")
    @PutMapping(value = "", produces = "application/json")
    public ResponseEntity<User> update(@RequestParam Long id,
                                       @RequestParam String username
//                                     @RequestParam Date modifiedDate
    ) {
        User user = userService.findById(id);
        user.setUsername(username);
//        user.setModifiedDate(modifiedDate);
        user.setVersion(user.getVersion() + 1);
        User updatedUser = userService.update(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(description = "Delete user by ID")
    @ApiResponse(responseCode = "200", description = "User was deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
        userService.findById(id); //Проверка успешного нахождения сущности в БД реализована в методе Service слоя
        userService.deleteById(id);
        return new ResponseEntity<>("User with id " + id + " was deleted", HttpStatus.OK);
    }
}
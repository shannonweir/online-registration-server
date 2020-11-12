package za.co.iqbusiness.onlineregistrationserver.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import za.co.iqbusiness.onlineregistrationserver.domain.User;
import za.co.iqbusiness.onlineregistrationserver.dto.Error;
import za.co.iqbusiness.onlineregistrationserver.service.UserService;

import java.util.List;

@EnableAutoConfiguration
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/online-registration/api")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger LOG = Logger.getLogger(UserController.class);

    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PutMapping("/user/{user_id}")
    public User update(@PathVariable("user_id") Long userId, @RequestBody User user) {
        return userService.update(userId, user);
    }

    @DeleteMapping("/person/{person_id}")
    public List<User> delete(@PathVariable("user_id") Long userId) {
        return userService.delete(userId);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({IllegalArgumentException.class})
    public Error illegalArgumentHandler(IllegalArgumentException e) {
        LOG.error("An error has occurred: " + e.toString(), e);
        Error error = new Error();
        error.setErrorCode("1");
        error.setMessage(e.getMessage());
        error.setExceptionMessage(e.getMessage());
        return error;
    }
}

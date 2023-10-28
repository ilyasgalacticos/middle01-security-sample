package kz.bitlab.middle.middlesecurity.api;

import kz.bitlab.middle.middlesecurity.dto.UserCreateDto;
import kz.bitlab.middle.middlesecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    public void createUser(@RequestBody UserCreateDto userCreateDto){
        userService.addUser(userCreateDto);
    }
}

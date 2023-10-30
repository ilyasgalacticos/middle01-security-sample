package kz.bitlab.middle.middlesecurity.api;

import kz.bitlab.middle.middlesecurity.beans.SomeBean;
import kz.bitlab.middle.middlesecurity.dto.UserCreateDto;
import kz.bitlab.middle.middlesecurity.dto.UserSignInDto;
import kz.bitlab.middle.middlesecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    private final SomeBean someBean;
    @PostMapping
    public void createUser(@RequestBody UserCreateDto userCreateDto){
        userService.addUser(userCreateDto);
    }

    @PostMapping(value = "/sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserSignInDto userSignInDto){
        return new ResponseEntity<>(userService.signIn(userSignInDto), HttpStatus.OK);
    }
}

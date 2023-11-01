package kz.bitlab.middle.middlesecurity.api;

import kz.bitlab.middle.middlesecurity.beans.SomeBean;
import kz.bitlab.middle.middlesecurity.dto.UserChangePasswordDto;
import kz.bitlab.middle.middlesecurity.dto.UserCreateDto;
import kz.bitlab.middle.middlesecurity.dto.UserSignInDto;
import kz.bitlab.middle.middlesecurity.service.UserService;
import kz.bitlab.middle.middlesecurity.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/update-password")
    @PreAuthorize("hasAnyRole('admin')")
    public ResponseEntity<?> changePassword(@RequestBody UserChangePasswordDto userChangePasswordDto){
        try{
            userService.changePassword(userChangePasswordDto.getUsername(), userChangePasswordDto.getPassword());
            return ResponseEntity.ok("Password changes successfully!");
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error on changing password");
        }
    }

    @PostMapping(value = "/update-own-password/{ownPassword}")
    public ResponseEntity<?> changeOwnPassword(@PathVariable(name = "ownPassword") String ownPassword){
        try{

            String currentUser = UserUtils.getCurrentUserName();
            if (currentUser != null) {
                userService.changePassword(currentUser, ownPassword);
                return ResponseEntity.ok("Password changes successfully");
            }

        }catch (RuntimeException e){
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error on changing password");
    }
}

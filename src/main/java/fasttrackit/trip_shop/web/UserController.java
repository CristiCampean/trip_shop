package fasttrackit.trip_shop.web;

import fasttrackit.trip_shop.domain.User;
import fasttrackit.trip_shop.service.UserService;
import fasttrackit.trip_shop.transfer.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;
@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserRequest request){
        User user = userService.createUser(request);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){

        User user = userService.getUser(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    @PutMapping
    public ResponseEntity<User>updateUser(long id,CreateUserRequest request){
        User user = userService.updateUser(id, request);
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
     public  ResponseEntity<User> deleteUser( @PathVariable long id){
         userService.deleteUser(id);
          return  new ResponseEntity<>( HttpStatus.NO_CONTENT);

     }
}

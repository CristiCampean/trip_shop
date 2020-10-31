package fasttrackit.trip_shop.service;

import fasttrackit.trip_shop.domain.User;
import fasttrackit.trip_shop.exception.ResourceNotFound;
import fasttrackit.trip_shop.persistence.UserRepository;
import fasttrackit.trip_shop.transfer.CreateUserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User createUser(CreateUserRequest request) {
        LOGGER.info("Creating user:{}", request);
        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        return userRepository.save(user);

    }

    public User getUser(long id) {
        LOGGER.info("Retrieving user{}", id);

        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(" User" + id + "does not exist"));

    }

    public User updateUser(long id, CreateUserRequest request){
        LOGGER.info(" Updating user {}:{}", id, request);

        User existingUser = getUser(id);
        BeanUtils.copyProperties(request, existingUser);

        return userRepository.save(existingUser);

    }
    public void deleteUser(long id){
        LOGGER.info("Deleting user{}", id);
        userRepository.deleteById(id);
    }
}
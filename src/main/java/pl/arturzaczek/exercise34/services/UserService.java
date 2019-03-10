package pl.arturzaczek.exercise34.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.arturzaczek.exercise34.entity.User;
import pl.arturzaczek.exercise34.form.UserLoginForm;
import pl.arturzaczek.exercise34.form.UserRegisterForm;
import pl.arturzaczek.exercise34.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserRegisterForm userRegisterForm){
//        User user = new User();
//        user.setEmail(userRegisterForm.getEmail());
//        user.setFirstName(userRegisterForm.getFirstName());
//        user.setLastName(userRegisterForm.getLastName());
//        user.setPasswordHash(userRegisterForm.getPassword());
//        user.setAddedDate(LocalDateTime.now());
//
//        userRepository.save(user);
    }
    public boolean loginUser(UserLoginForm userLoginForm){
        Optional<User> userEntity = userRepository.getUserEntityByEmail(userLoginForm.getEmail());
        if(userEntity.isPresent()){
            return true;
        }
        return false;
    }
}

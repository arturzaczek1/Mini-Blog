package pl.arturzaczek.exercise34.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.arturzaczek.exercise34.entity.Role;
import pl.arturzaczek.exercise34.entity.User;
import pl.arturzaczek.exercise34.form.UserLoginForm;
import pl.arturzaczek.exercise34.form.UserRegisterForm;
import pl.arturzaczek.exercise34.repository.RoleRepository;
import pl.arturzaczek.exercise34.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserService {

    public static final String ROLE_USER = "ROLE_USER";
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegisterForm userRegisterForm) {
        User user = new User();
        user.setEmail(userRegisterForm.getEmail());
        user.setFirstName(userRegisterForm.getFirstName());
        user.setLastName(userRegisterForm.getLastName());
        user.setPasswordHash(passwordEncoder.encode(userRegisterForm.getPassword()));
        user.setAddedDate(LocalDateTime.now());
//        Optional<Role> optionalRole = roleRepository.findByRoleName(ROLE_USER);
//        if(!optionalRole.isPresent()) {
//            Role role = new Role(ROLE_USER);
//            roleRepository.save(role);
//        }
        getORCreateDefaultRole(user);
        userRepository.save(user);
    }

    public boolean loginUser(UserLoginForm userLoginForm) {
        Optional<User> userEntity = userRepository.getUserEntityByEmail(userLoginForm.getEmail());
        if (userEntity.isPresent()) {
            return true;
        }
        return false;
    }

    private void getORCreateDefaultRole(User user) {
        Role role = roleRepository.findByRoleName(ROLE_USER)
                .orElseGet(() -> roleRepository.save(new Role(ROLE_USER)));
//        Set<Role> roles = new HashSet<>();
//        roles.add(role);
//        user.setRoles(roles);
        user.addRole(role);
    }
}

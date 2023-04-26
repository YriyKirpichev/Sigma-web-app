package sigma.project.travelAgency.service.imp;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sigma.project.travelAgency.entity.Role;
import sigma.project.travelAgency.entity.User;
import sigma.project.travelAgency.repository.RoleRepository;
import sigma.project.travelAgency.repository.UserRepository;
import sigma.project.travelAgency.service.UserService;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user,String role) {
        log.info("Create user: '{}'", user.getUsername());
      //  log.info("Create user: '{},{},{},{},{},{},{},{}'", user.getFirstName(),user.getMiddleName(),user.getSecondName(), user.getUsername(),user.getPassword(),user.getBirthDate(),user.getPhone(),user.getId());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findByName(role).stream()
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("User cannot be created"));
      //  log.info("Role: '{}'",userRole.getName());
        user.setRoles(List.of(userRole));
        return userRepository.save(user);
    }

    @Override
    public boolean checkUsername(String username) {
        log.info("Check if user with email: '{}' exists", username);
        return userRepository.existsByUsername(username);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        log.info("Searching user by email: '{}'", username);
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("User doesn't exists"));
    }

}

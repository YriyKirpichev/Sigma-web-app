package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user, String role);

    User getUserByUsername(String username);

//    User getUserByRole(String role);
    boolean checkUsername(String username);

    List<User> getAllUsers();

}

package sigma.project.travelAgency.service;

import sigma.project.travelAgency.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserByUsername(String username);

    boolean checkUsername(String username);

    List<User> getAllUsers();

}
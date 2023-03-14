package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void removeUserById(long id);

    void cleanUsersTable();
    User findUserByCarModelAndCarSeries(String carModel, int carSeries);
}

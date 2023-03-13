package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   public UserServiceImp(UserDao userDao) {
      this.userDao = userDao;
   }

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void removeUserById(long id) {
      userDao.removeUserById(id);
   }

   @Transactional
   @Override
   public void cleanUsersTable() {
      userDao.cleanUsersTable();
   }

   @Transactional
   @Override
   public User findUser(String carModel, int carSeries) {
      return userDao.findUser(carModel, carSeries);
   }

}
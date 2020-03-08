package cn.eigth.purchaseforward.service.impl;

import cn.eigth.purchaseforward.dao.UserDao;
import cn.eigth.purchaseforward.pojo.User;
import cn.eigth.purchaseforward.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new  UserDao();
    @Override
    public boolean checkUser(User user) {
        return userDao.queryUser(user);
    }
}

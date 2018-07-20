package ru.agronomych.bellProject.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import ru.agronomych.bellProject.user.dao.UserDao;
import ru.agronomych.bellProject.user.view.UserView;

import java.util.List;

public class UserServiceImpl implements UserService{

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public List<UserView> users(){
        List<UserView> users = null;
        return users;
    }

    @Override
    public void saveUser(UserView user){

    }

    @Override
    public void updateUser(UserView user){

    }

    @Override
    public UserView loadById(int id){
        UserView user = null;
        return user;
    }
}

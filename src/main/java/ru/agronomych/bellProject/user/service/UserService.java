package ru.agronomych.bellProject.user.service;

import ru.agronomych.bellProject.user.view.UserView;

import java.util.List;

public interface UserService {

    List<UserView> users();

    void saveUser(UserView user);

    void updateUser(UserView user);

    UserView loadById(int id);
}

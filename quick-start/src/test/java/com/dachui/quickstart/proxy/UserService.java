package com.dachui.quickstart.proxy;

public interface UserService {
    public void addUser(int id, String name, int age);

    public void deleteUser(int id);

    public String getUserName(int id);

}

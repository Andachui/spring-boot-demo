package com.dachui.quickstart.proxy;

public class UserServiceImpl implements UserService{
    @Override
    public void addUser(int id, String name, int age) {
        System.out.println("------------addUser()-----------");
    }

    @Override
    public void deleteUser(int id) {
        System.out.println("------------deleteUser()-----------");
    }

    @Override
    public String getUserName(int id) {
        System.out.println("------------getUserName()-----------");
        return "zs";
    }

}

package com.jdbcapp.StudentJDBCApp;


public class Main {
    public static void main(String[] args) {
        System.out.println("Student Database");
        IMenu menu = new MenuImpl();
        menu.showMenu();
    }
}

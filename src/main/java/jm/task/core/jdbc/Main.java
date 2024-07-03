package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import static jm.task.core.jdbc.util.Util.shutdown;

public class Main {
    public static void main(String[] args) {
        User[] employee = new User[] {
                new User(),
                new User("Genrich", "Institoris", (byte) 45),
                new User("Jacob", "Schprengler", (byte) 60),
                new User("Jordano", "Bruno", (byte) 55)
        };

        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        for (User u : employee) {
            userService.saveUser(u.getName(), u.getLastName(), u.getAge());
            System.out.println("User named - " + u.getName() + " insert in database");
        }
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
        shutdown();
    }
}

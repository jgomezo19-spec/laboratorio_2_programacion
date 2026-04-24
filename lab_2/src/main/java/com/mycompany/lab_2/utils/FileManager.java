package com.mycompany.lab_2.utils;

import com.mycompany.lab_2.models.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "users.txt";
    private static int nextId = 1;

    static {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                List<User> defaultUsers = new ArrayList<>();
                defaultUsers.add(new User(nextId++, "Super Admin", "superadmin", "Admin123!", "admin supremo", "activo", "Jefe"));
                saveAllUsers(defaultUsers);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            nextId = getNextAvailableId();
        }
    }

    private static int getNextAvailableId() {
        List<User> users = loadAllUsers();
        return users.stream().mapToInt(User::getId).max().orElse(0) + 1;
    }

    public static List<User> loadAllUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 7) {
                    users.add(new User(
                        Integer.parseInt(parts[0]), parts[1], parts[2], parts[3],
                        parts[4], parts[5], parts[6]
                    ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void saveAllUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User u : users) {
                writer.write(u.getId() + ";" + u.getName() + ";" + u.getUsername() + ";" +
                             u.getPassword() + ";" + u.getRole() + ";" + u.getStatus() + ";" + u.getPosition());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void incrementNextId() {
        nextId++;
    }
}

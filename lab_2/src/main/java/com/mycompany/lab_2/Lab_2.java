package com.mycompany.lab_2;

import com.mycompany.lab_2.views.LoginView;

public class Lab_2 {
    
    public static void main(String[] args) {
        // Ejecutar la ventana de login
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}
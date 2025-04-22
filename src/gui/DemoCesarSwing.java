package gui;

import javax.swing.*;

public class DemoCesarSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainWindow window=new MainWindow();
            window.setVisible(true);
        });
    }
}
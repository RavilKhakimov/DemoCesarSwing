package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import filamanager.FileManager;
import cesarcipher.StatisticalAnalyzer;

public class StatAnalysisWindow implements Serializable {
    public StatAnalysisWindow() {
    }

    void openStatAnalysisWindow() {
        JFrame frame = new JFrame("Статистический анализ");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelInputEncrypted = new JLabel("Путь к зашифрованному файлу:");
        JTextField fieldEncryptedInput = new JTextField(20);
        fieldEncryptedInput.setPreferredSize(new Dimension(200, 30));

        JButton btnStart = new JButton("Старт");

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInputEncrypted, gbc);
        gbc.gridx = 1;
        panel.add(fieldEncryptedInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnStart, gbc);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        btnStart.addActionListener(e -> {
            String encryptedFilePath = fieldEncryptedInput.getText().trim();

            if (encryptedFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Заполните все поля!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            FileManager fileManager = new FileManager();

            List<String> textFromFile = fileManager.readFile(encryptedFilePath);

            int key = StatisticalAnalyzer.breakCaesarCipher(textFromFile);

            // Логика статистического анализа
            System.out.println("Статистический анализ:");
            System.out.println("Зашифрованный файл: " + encryptedFilePath);


            JOptionPane.showMessageDialog(frame, "Статистический анализ выполнен. Найденный сдвиг: " + key);
            frame.dispose();
        });
    }
}
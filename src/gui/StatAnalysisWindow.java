package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

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

        JLabel labelInputReference = new JLabel("Путь к эталонному файлу:");
        JTextField fieldReferenceInput = new JTextField(20);

        JButton btnStart = new JButton("Старт");

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInputEncrypted, gbc);
        gbc.gridx = 1;
        panel.add(fieldEncryptedInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelInputReference, gbc);
        gbc.gridx = 1;
        panel.add(fieldReferenceInput, gbc);

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
            String referenceFilePath = fieldReferenceInput.getText().trim();

            if (encryptedFilePath.isEmpty() || referenceFilePath.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Заполните все поля!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Логика статистического анализа
            System.out.println("Статистический анализ:");
            System.out.println("Зашифрованный файл: " + encryptedFilePath);
            System.out.println("Эталонный файл: " + referenceFilePath);

            JOptionPane.showMessageDialog(frame, "Статистический анализ выполнен (заглушка).");
            frame.dispose();
        });
    }
}
package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cesarcipher.Alphabet;
import cesarcipher.BruteForce;
import filamanager.FileManager;

public class BruteForceWindow implements Serializable {
    public BruteForceWindow() {
    }

    void openBruteForceWindow() {
        JFrame frame = new JFrame("БрудФорс");
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelInput = new JLabel("Путь к зашифрованному файлу:");
        JTextField fieldInput = new JTextField(20);
        fieldInput.setPreferredSize(new Dimension(200, 30));

        JLabel labelOutput = new JLabel("Путь к оригинальному файлу:");
        JTextField fieldOutput = new JTextField(20);
        fieldOutput.setPreferredSize(new Dimension(200, 30));

        JButton btnStart = new JButton("Старт");

        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInput, gbc);
        gbc.gridx = 1;
        panel.add(fieldInput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(labelOutput, gbc);
        gbc.gridx = 1;
        panel.add(fieldOutput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnStart, gbc);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        btnStart.addActionListener(e -> {
            String inputPath = fieldInput.getText().trim();
            String outputPath = fieldOutput.getText().trim();
            if (inputPath.isEmpty() || outputPath.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Заполните все поля!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Alphabet Alphabet = new Alphabet();
            FileManager fileManager = new FileManager();
            BruteForce bruteForce = new BruteForce(Alphabet);

            List<String> textFromFile = fileManager.readFile(inputPath);
            List<String> textOriginal = fileManager.readFile(outputPath);

            int bruteForceDecryptedKey = bruteForce.decryptByBruteForce(textFromFile.get(0), textOriginal.get(0));

            // Логика брутфорса
            System.out.println("Брутфорс:");
            System.out.println("Зашифрованный файл: " + inputPath);
            System.out.println("Оригинальный файл: " + outputPath);
            System.out.println("Расшифрованный люч: " + bruteForceDecryptedKey);

            JOptionPane.showMessageDialog(frame, "Брутфорс выполнен. Расшифрованный люч: " + bruteForceDecryptedKey);
            frame.dispose();
        });
    }
}
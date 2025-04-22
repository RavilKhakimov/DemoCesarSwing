package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class DecryptWindow implements Serializable {
    public DecryptWindow() {
    }

    void openDecryptWindow() {
        // Аналогично openEncryptWindow, только с полями для расшифровки
        JFrame frame = new JFrame("Расшифровка");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelInput = new JLabel("Путь к зашифрованному файлу:");
        JTextField fieldInput = new JTextField(20);

        JLabel labelKey = new JLabel("Ключ шифра:");
        JTextField fieldKey = new JTextField(20);

        JLabel labelOutput = new JLabel("Путь к выходному файлу:");
        JTextField fieldOutput = new JTextField(20);

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
        panel.add(labelKey, gbc);
        gbc.gridx = 1;
        panel.add(fieldKey, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelOutput, gbc);
        gbc.gridx = 1;
        panel.add(fieldOutput, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(btnStart, gbc);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        btnStart.addActionListener(e -> {
            String inputPath = fieldInput.getText().trim();
            String keyStr = fieldKey.getText().trim();
            String outputPath = fieldOutput.getText().trim();

            if (inputPath.isEmpty() || keyStr.isEmpty() || outputPath.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Заполните все поля!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Добавьте логику расшифровки
            System.out.println("Расшифровка:");
            System.out.println("Входной файл: " + inputPath);
            System.out.println("Ключ: " + keyStr);
            System.out.println("Выходной файл: " + outputPath);

            JOptionPane.showMessageDialog(frame, "Расшифровка выполнена (заглушка).");
            frame.dispose();
        });
    }
}
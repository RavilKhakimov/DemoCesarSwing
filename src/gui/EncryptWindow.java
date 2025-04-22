package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class EncryptWindow implements Serializable {
    public EncryptWindow() {
    }

    void openEncryptWindow() {
        JFrame frame = new JFrame("Шифровка");
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel labelInput = new JLabel("Путь к входному файлу:");
        JTextField fieldInput = new JTextField(20);
        fieldInput.setPreferredSize(new Dimension(200, 30));

        JLabel labelKey = new JLabel("Ключ шифра:");
        JTextField fieldKey = new JTextField(20);
        fieldKey.setPreferredSize(new Dimension(200, 30));

        JLabel labelOutput = new JLabel("Путь к выходному файлу:");
        JTextField fieldOutput = new JTextField(20);
        fieldOutput.setPreferredSize(new Dimension(200, 30));

        JButton btnStart = new JButton("Старт");

        gbc.insets = new Insets(10, 10, 10, 10);
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

            // Здесь добавьте логику шифровки с использованием inputPath, keyStr и outputPath
            System.out.println("Шифровка:");
            System.out.println("Входной файл: " + inputPath);
            System.out.println("Ключ: " + keyStr);
            System.out.println("Выходной файл: " + outputPath);

            JOptionPane.showMessageDialog(frame, "Шифровка выполнена (заглушка).");
            frame.dispose();
        });
    }
}
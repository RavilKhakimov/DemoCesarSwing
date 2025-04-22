package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

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

            // Логика брутфорса
            System.out.println("Брутфорс:");
            System.out.println("Входной файл: " + inputPath);
            System.out.println("Выходной файл: " + outputPath);

            JOptionPane.showMessageDialog(frame, "Брутфорс выполнен (заглушка).");
            frame.dispose();
        });
    }
}
package gui;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cesarcipher.Cipher;
import cesarcipher.Alphabet;
import filamanager.FileManager;
import validation.Valid;
import exeptions.InvalidKeyException;

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
        fieldInput.setPreferredSize(new Dimension(200, 30));

        JLabel labelKey = new JLabel("Ключ шифра:");
        JTextField fieldKey = new JTextField(20);
        fieldKey.setPreferredSize(new Dimension(200, 30));

        JLabel labelOutput = new JLabel("Путь к выходному файлу:");
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
            if(!Valid.isValidKey(Integer.parseInt(keyStr))){
                JOptionPane.showMessageDialog(frame, "Не подходящий ключ", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if(!Valid.isFileExists(inputPath) | !Valid.isFileExists(outputPath)){
                JOptionPane.showMessageDialog(frame, "Файл для чтения или записи не существует", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Alphabet Alphabet = new Alphabet();
            Cipher cipher = new Cipher(Alphabet, Integer.parseInt(keyStr));
            FileManager fileManager = new FileManager();

            List<String> textFromFile = fileManager.readFile(inputPath);

            List<String> dencryptStrings = new ArrayList<>();

            for (int i = 0; i < textFromFile.size() - 1; i++) {
                dencryptStrings.add(cipher.decrypt(textFromFile.get(i), Integer.parseInt(keyStr)));
            }

            fileManager.writeToFile(outputPath, dencryptStrings);

            System.out.println("Расшифровка:");
            System.out.println("Входной файл: " + inputPath);
            System.out.println("Ключ: " + keyStr);
            System.out.println("Выходной файл: " + outputPath);

            JOptionPane.showMessageDialog(frame, "Расшифровка выполнена.\n" +
                    "Входной файл: " + inputPath + "\n" +
                    "Ключ: " + keyStr + "\n" +
                    "Выходной файл: " + outputPath);
            frame.dispose();
        });
    }
}
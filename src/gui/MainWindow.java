package gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DecryptWindow openDecryptWindow = new DecryptWindow();
    private final BruteForceWindow bruteForceWindow = new BruteForceWindow();
    private final StatAnalysisWindow statAnalysisWindow = new StatAnalysisWindow();
    private final EncryptWindow encryptWindow = new EncryptWindow();

    public MainWindow() {
        setTitle("Криптоанализатор");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        initUI();
    }

    private void initUI() {
        // Используем GridLayout для 5 кнопок по вертикали
        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton btnEncrypt = new JButton("1 Шифровка");
        JButton btnDecrypt = new JButton("2 Расшифровка");
        JButton btnBruteForce = new JButton("3 БрудФорс");
        JButton btnStatAnalysis = new JButton("4 СтатАнализ");
        JButton btnExit = new JButton("5 Выход");

        panel.add(btnEncrypt);
        panel.add(btnDecrypt);
        panel.add(btnBruteForce);
        panel.add(btnStatAnalysis);
        panel.add(btnExit);

        add(panel);

        // Обработчики кнопок
        btnEncrypt.addActionListener(e -> encryptWindow.openEncryptWindow());
        btnDecrypt.addActionListener(e -> openDecryptWindow.openDecryptWindow());
        btnBruteForce.addActionListener(e -> bruteForceWindow.openBruteForceWindow());
        btnStatAnalysis.addActionListener(e -> statAnalysisWindow.openStatAnalysisWindow());
        btnExit.addActionListener(e -> System.exit(0));
    }

    private void openEncryptWindow() {

        encryptWindow.openEncryptWindow();
    }

    private void openDecryptWindow() {
        // Аналогично openEncryptWindow, только с полями для расшифровки

        openDecryptWindow.openDecryptWindow();
    }

    private void openBruteForceWindow() {

        bruteForceWindow.openBruteForceWindow();
    }

    private void openStatAnalysisWindow() {

        statAnalysisWindow.openStatAnalysisWindow();
    }
}




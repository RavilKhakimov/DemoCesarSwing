package gui;

import javax.swing.*;

public class DemoCesarSwing {
    public static void main(String[] args) {
        // Метод invokeLater помещает этот код в очередь событий
        // Event Dispatch Thread (EDT) — специального потока, ответственного за обновление GUI в Swing.
        // Это делается для того, чтобы все операции с графическим интерфейсом выполнялись в правильном потоке,
        // что предотвращает ошибки и некорректное поведение.
        SwingUtilities.invokeLater(() -> {
            MainWindow window=new MainWindow();
            window.setVisible(true);
            window.setAlwaysOnTop(true);
        });
    }
}
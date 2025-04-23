import java.util.ArrayList;
import java.util.List;

//Отвечает за обработку команд пользователя, вызов
//соответствующих методов и управление потоком работы программы.
public class TestApp {
    public static void main(String[] args) {

        Alphabet Alphabet = new Alphabet();
        Cipher cipher = new Cipher(Alphabet, 11);
        BruteForce bruteForce = new BruteForce(Alphabet);
        FileManager fileManager = new FileManager();
        String text = "Пример текста! Как дела? Всё хорошо.";
        int shiftLetters = 11;  // сдвиг для букв

        System.out.println("Пример текста:");
        System.out.println(text);
        String encrypted = cipher.encrypt(text);
        System.out.println("Зашифрованный текст:");
        System.out.println(encrypted);
        String decrypted = cipher.decrypt(encrypted, shiftLetters);
        System.out.println("Раcшифрованный текст:");
        System.out.println(decrypted);
        int bruteForceDecrypted = bruteForce.decryptByBruteForce(encrypted, text);
        System.out.println("Раcшифрованный грубой силой key:");
        System.out.println(bruteForceDecrypted);
        List<String> textFromFile = new ArrayList<>();

        textFromFile = fileManager.readFile("Test.txt");
        System.out.println("Строка считанного файла:");
        System.out.println(textFromFile.get(0));

        List<String> encryptStrings = new ArrayList<>();

        for (int i = 0; i < textFromFile.size() - 1; i++) {
            encryptStrings.add(cipher.encrypt(textFromFile.get(i)));
        }
        System.out.println("Зашифрованная строка для записи в файл:");
        System.out.println(encryptStrings.get(0));

        fileManager.writeToFile("texts/TestToWrite.txt", encryptStrings);

         // Пример зашифрованного текста

        int key = StatisticalAnalyzer.breakCaesarCipher(encrypted);
        System.out.println("Найденный сдвиг: " + key);

    }
}
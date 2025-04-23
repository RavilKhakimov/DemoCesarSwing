package cesarcipher;

import java.util.ArrayList;

//Реализация метода перебора всех ключей для взлома
public class BruteForce {
    private Alphabet alphabet;

    public BruteForce(Alphabet alphabet) {
        this.alphabet = alphabet;
    }
    // метод cesarcipher.BruteForce принимает зашифрованный текст и исходный текст для сравнения, возвращает расшифрованный текст
    public int decryptByBruteForce(String encryptedText, String inputText) {
        StringBuilder decryptText = new StringBuilder();
        ArrayList<String> decryptList = new ArrayList<>();
        int key = 0;
        //каждый символ с зашифрованной строке смещает на все возможные значения ключа
        //каждый вариант расшифрованной строки записывает в ArrayList строк
        for (int i = 1; i < alphabet.size(); i++) {
            for (char c : encryptedText.toCharArray()){
                int index = alphabet.indexOf(c);
                if(index != -1){
                    int newIndex = (index - i + alphabet.size()) % alphabet.size();
                    decryptText.append(alphabet.getCharAt(newIndex));
                }else {
                    decryptText.append(c);
                }
            }
            decryptList.add(String.valueOf(decryptText));
            decryptText.delete(0, inputText.length());
        }
        //каждый вариант расшифрованной строки из ArrayList строк сравнивает с правильным и возвращает ключ
        for (int i = 0; i < decryptList.size(); i++) {
            if(decryptList.get(i).equals(inputText))
                key = i + 1;
        }
        return key;
    }
}

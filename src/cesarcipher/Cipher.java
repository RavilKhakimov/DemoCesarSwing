package cesarcipher;

//Класс, реализующий функциональность шифра Цезаря и дешифровки
public class Cipher {
    private Alphabet alphabet;
    private int shift;

    public Cipher(Alphabet alphabet, int shift) {
        this.alphabet = alphabet;
        this.shift = shift % alphabet.size();
    }
    // метод шифрования по строкам, возвращает строку
    public String encrypt(String inputText) {
        StringBuilder encryptText = new StringBuilder();
        for (char c : inputText.toCharArray()){
            int index = alphabet.indexOf(c);
            if(index != -1){
                int newIndex = (index + shift) % alphabet.size();
                encryptText.append(alphabet.getCharAt(newIndex));
            }else {
                encryptText.append(c);
            }
        }
        return encryptText.toString();
    }
    // метод дешифровки по строкам, возвращает строку
    public String decrypt(String encryptedText, int shift) {
        StringBuilder decryptText = new StringBuilder();
        for (char c : encryptedText.toCharArray()){
            int index = alphabet.indexOf(c);
            if(index != -1){
                int newIndex = (index - shift + alphabet.size()) % alphabet.size();
                decryptText.append(alphabet.getCharAt(newIndex));
            }else {
                decryptText.append(c);
            }
        }
        return decryptText.toString();
    }

}

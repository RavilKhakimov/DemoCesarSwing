package validation;

import exeptions.InvalidKeyException;
import cesarcipher.Alphabet;
import java.io.File;

//Валидация входных данных, таких как существование файла, допустимость ключа
public class Valid {
    public static boolean isValidKey(int key) {
        Alphabet Alphabet = new Alphabet();
        if(key >= 0 && key < cesarcipher.Alphabet.getAlphabetRu().length){
            return true;
        }else{
            return false;
        }
    }
    public static boolean isNumeric(String key) {
        return key != null && key.matches("\\d+");
    }

    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
       if (file.exists() && file.isFile()){
           return true;
       }else {
           return false;
       }

    }

}

package validation;

import exeptions.InvalidKeyException;

//Валидация входных данных, таких как существование файла, допустимость ключа
public class Validator {
    public boolean isValidKey(int key, char[] alphabet) {
    return true;
    }
    public boolean isFileExists(String filePath) {
        return true;  // Проверка существования файла
    }
    public static void validKey(int key){
        if(key < 1 || key > 32){
            throw new InvalidKeyException();
        }
    }

}

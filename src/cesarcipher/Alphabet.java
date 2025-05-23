package cesarcipher;

public class Alphabet {
    //массив кириллицы (заглавные и строчные символы) со знаками препинания
    private static final char[] ALPHABET_RU = {'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж',
            'З', 'И','Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т','У',
            'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я',
            'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з', 'и', 'к', 'л', 'м', 'н',
            'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы',
            'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', '-', ' '};

    //метод возвращает символ по индексу
    public char getCharAt(int index) {
                return ALPHABET_RU[index];
    }

    //метод возвращает индекс символа
    public int indexOf(char key) {
        for (int i = 0; i < ALPHABET_RU.length; i++) {
            if (ALPHABET_RU[i] == key) {
                return i;
            }
        }
        return -1;
    }
    //метод возвращает размер массива(алфавита)
    public static int size() {
        return ALPHABET_RU.length;
        }

    //метод возвращает алфавит
    public static char[] getAlphabetRu() {
        char[] AlphabetRu = ALPHABET_RU;
        return AlphabetRu;
    }
}

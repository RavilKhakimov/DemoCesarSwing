
//Для статистического анализа при расшифровке
public class StatisticalAnalyzer {
    static Alphabet alphabet = new Alphabet();

    private static int ALPHABET_SIZE = alphabet.size();
    private static final char FIRST_UPPER = 'А';
    private static final char FIRST_LOWER = 'а';

    // Частоты букв русского языка в процентах (без Ё)
    // Порядок: А, Б, В, Г, Д, Е, Ж, З, И, Й, К, Л, М, Н, О, П, Р, С, Т, У, Ф, Х, Ц, Ч, Ш, Щ, Ъ, Ы, Ь, Э, Ю, Я
    private static final double[] RUSSIAN_LETTER_FREQ = {
            8.01, 1.59, 4.54, 1.70, 2.98,
            8.45, 0.94, 1.65, 7.35, 1.21,
            3.49, 4.40, 3.21, 6.70,10.97,
            2.81, 4.73, 5.47, 6.26, 2.62,
            0.26, 0.97, 0.48, 1.44, 0.73,
            0.36, 0.04, 1.90, 1.74, 0.32,
            0.64, 2.01
    };

    public static String decryptWithShift(String encryptedText, int shift) {
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

    public static double[] calculateLetterFrequencies(String text) {
        double[] freq = new double[RUSSIAN_LETTER_FREQ.length];
        int totalLetters = 0;

        for (char c : text.toCharArray()) {
            if (c >= 'А' && c <= 'Я') {
                freq[c - FIRST_UPPER]++;
                totalLetters++;
            } else if (c >= 'а' && c <= 'я') {
                freq[c - FIRST_LOWER]++;
                totalLetters++;
            }
            // Игнорируем остальные символы
        }

        if (totalLetters == 0) return freq;

        for (int i = 0; i < freq.length; i++) {
            freq[i] = freq[i] / totalLetters * 100;
        }

        return freq;
    }

    public static double frequencyDistance(double[] freq1, double[] freq2) {
        double dist = 0;
        for (int i = 0; i < freq1.length; i++) {
            double diff = freq1[i] - freq2[i];
            dist += diff * diff;
        }
        return dist;
    }

    public static int breakCaesarCipher(String cipherText) {
        double minDistance = Double.MAX_VALUE;
        int bestShift = 0;

        for (int shift = 0; shift < RUSSIAN_LETTER_FREQ.length; shift++) {
            String decrypted = decryptWithShift(cipherText, shift);
            double[] freq = calculateLetterFrequencies(decrypted);
            double dist = frequencyDistance(freq, RUSSIAN_LETTER_FREQ);
            if (dist < minDistance) {
                minDistance = dist;
                bestShift = shift;
            }
        }

        return bestShift;
    }

}

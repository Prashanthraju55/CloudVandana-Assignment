import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class pangram {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        shuffleArray(array);
        System.out.println("Array after Shuffling: " + Arrays.toString(array));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your Roman Number here: ");
        String romanNumber = scanner.nextLine();
        int integerValue = romanToInteger(romanNumber);
        System.out.println("Integer value of roman number: " + integerValue);

        System.out.println("Type your sentence:");
        String sentence = scanner.nextLine();
        boolean isPangram = isPangram(sentence);
        System.out.println(isPangram); //if output is true then it's a pangram and Viceversa
    }

    private static void shuffleArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int randomIndex = (int) (Math.random() * array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    private static int romanToInteger(String romanNumber) {
        HashMap<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        int integerValue = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int currentValue = romanNumerals.get(romanNumber.charAt(i));
            if (i > 0 && currentValue > romanNumerals.get(romanNumber.charAt(i - 1))) {
                integerValue += currentValue - 2 * romanNumerals.get(romanNumber.charAt(i - 1));
            } else {
                integerValue += currentValue;
            }
        }
        return integerValue;
    }
    public static boolean isPangram(String sentence) {
        sentence = sentence.toLowerCase();
        HashSet<Character> alphabets = new HashSet<>();
        for(char ch: sentence.toCharArray()) {
            if(Character.isLetter(ch)) {
                alphabets.add(ch);
            }
        }
        return alphabets.size() == 26;
    }
}

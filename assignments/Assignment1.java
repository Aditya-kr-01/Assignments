package assignments;
import java.util.*;

public class Assignment1 {

    // Function to get value of character
    static int getValue(char c) {
        return c - 'a' + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();

        // Create doubled string for cyclic handling
        String doubled = s + s;

        // Sliding window
        Set<Character> set = new HashSet<>();

        int left = 0;
        int currentSum = 0;
        int maxSum = 0;

        for (int right = 0; right < doubled.length(); right++) {

            char ch = doubled.charAt(right);

            // Remove duplicates OR window size > n
            while (set.contains(ch) || (right - left + 1) > n) {
                char leftChar = doubled.charAt(left);

                set.remove(leftChar);
                currentSum -= getValue(leftChar);

                left++;
            }

            set.add(ch);
            currentSum += getValue(ch);

            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}

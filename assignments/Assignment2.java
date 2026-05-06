package assignments;
import java.util.*;

public class Assignment2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // Check if transformation is possible
        int remainder = arr[0] % k;

        for (int i = 1; i < n; i++) {
            if (arr[i] % k != remainder) {
                System.out.println(-1);
                return;
            }
        }

        // Sort array
        Arrays.sort(arr);

        // Median gives minimum operations
        int target = arr[n / 2];

        long operations = 0;

        for (int i = 0; i < n; i++) {
            operations += Math.abs(arr[i] - target) / k;
        }

        System.out.println(operations);
    }
}

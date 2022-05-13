import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class MaxMin {
    static void sorting(String arr[]) {
        int minPos;

        for (int i = 0; i < arr.length - 2; i++) {
            int temp = Integer.parseInt(arr[i]);
            minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (temp > Integer.parseInt(arr[j])) {
                    temp = Integer.parseInt(arr[j]);
                    minPos = j;
                }
            }

            // swap
            if (minPos != i) {
                String temp2 = arr[minPos];
                arr[minPos] = arr[i];
                arr[i] = temp2;
            }

        }
    }

    static void maxMin(String arr[]) {

        MaxMin.sorting(arr);
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += Integer.parseInt(arr[i]);
        }
        int minimum = total - Integer.parseInt(arr[arr.length - 1]);
        int maximum = total - Integer.parseInt(arr[0]);

        System.out.println(minimum + " " + maximum);
    }
}

public class MiniMaxOfFourFive {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = bf.readLine().split(" ");

        MaxMin.maxMin(arr);

    }
}

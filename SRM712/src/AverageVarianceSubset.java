import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AverageVarianceSubset {

    static int[] s;
    static int R;
    static ArrayList<Double> Y = new ArrayList<Double>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // {1,2,3}
        // 3
        String input = br.readLine();

        input = input.substring(1, input.length() - 1);
        String[] inputArr = input.split(",");

        s = new int[inputArr.length];

        for (int i = 0; i < s.length; i++) {

            s[i] = Integer.parseInt(inputArr[i]);
        }

        R = Integer.parseInt(br.readLine());

        System.out.println(average(s, R));
    }

    public static double average(int[] s, int R) {

        int length = s.length;

        for (int i = 1; i <= length; i++) {

            int[] tempArr = new int[length];

            for (int j = 0; j < length; j++) {

                tempArr[j] = 0;
            }

            combination(tempArr, i, i, length, 0, 0);
        }

        double sum = 0.0;
        for (double y : Y) {

            sum += y;
        }

        return sum / ((double) Y.size());
    }


    // return mu;
    public static void combination(int[] arr, int k, int length, int n, int target, int index) {

        if (k == 0) {

            if (length != 1 && arr[length - 1] - arr[0] > R) return;

            int sum = 0;
            for (int j = 0; j < length; j++) {

                sum += arr[j];
            }

            double mu = ((double) sum) / ((double) length);

            double y = 0.0;
            for (int j = 0; j < length; j++) {

                y += (mu - arr[j]) * (mu - arr[j]);
            }

            y = y / ((double) length);
            Y.add(y);

        } else if (target == n) {

            return;
        } else {

            arr[index] = s[target];

            combination(arr, k - 1, length, n, target + 1, index + 1);
            combination(arr, k, length, n, target + 1, index);
        }
    }
}

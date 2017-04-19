import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RepeatNumberCompare {

    public static void main(String[] args) throws IOException {

        int x1, k1, x2, k2;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        x1 = Integer.parseInt(br.readLine());
        k1 = Integer.parseInt(br.readLine());
        x2 = Integer.parseInt(br.readLine());
        k2 = Integer.parseInt(br.readLine());

        System.out.println(compare(x1, k1, x2, k2));
    }

    public static String compare(int x1, int k1, int x2, int k2) {

        // v1
        String v1 = "";

        for (int i = 0; i < k1; i++) {

            v1 += x1;
        }


        // v2
        String v2 = "";
        for (int i = 0; i < k2; i++) {

            v2 += x2;
        }

        // compare
        if (v1.length() < v2.length()) {

            return new String("Less");
        } else if (v1.length() > v2.length()) {

            return new String("Greater");
        } else {

            for (int i = 0; i < v1.length(); i++) {

                int a = v1.charAt(i) - '0';
                int b = v2.charAt(i) - '0';

                if (a < b) {

                    return new String("Less");
                } else if (a > b) {

                    return new String("Greater");
                }
            }

            return new String("Equal");
        }
    }
}

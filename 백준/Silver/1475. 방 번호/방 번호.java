import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - '0';
            if (idx == 9)
                idx = 6;
            arr[idx]++;
        }
        arr[9] = arr[6] / 2;
        arr[6] -= arr[9];

        int max = Integer.MIN_VALUE;
        for (int i : arr)
            max = Math.max(max, i);
        System.out.println(max);
        br.close();
    }
}
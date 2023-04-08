import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int sum = A*B*C;
        String sumStr = sum+"";

        int[] arr = new int[10];

        for(int i=0; i< sumStr.length(); i++)
            arr[sumStr.charAt(i)-'0']++;

        for(int i=0; i<10; i++)
            System.out.println(arr[i]);
    }
}
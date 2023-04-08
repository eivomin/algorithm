import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String[] arrA = st.nextToken().split("");
            String[] arrB = st.nextToken().split("");

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for(int j=0; j<arrA.length; j++)
                sb1.append(arrA[j]);

            for(int j=0; j<arrB.length; j++)
                sb2.append(arrB[j]);

            if(sb1.toString().equals(sb2.toString()))
                System.out.println("Possible");
            else System.out.println("Impossible");

        }
        br.close();
    }
}
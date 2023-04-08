import java.io.*;

/*
* a~z 26개 , a = 97
* */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int[] arr = new int[26];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<S.length(); i++){
            arr[S.charAt(i)-97]++;
        }

        for(int i=0; i<26; i++)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
        br.close();

    }
}
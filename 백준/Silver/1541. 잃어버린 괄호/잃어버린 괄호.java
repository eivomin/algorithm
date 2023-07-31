import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer subtraction = new StringTokenizer(br.readLine(), "-");
        //10 - 20+30 - 40+50 - 70

        int sum = Integer.MAX_VALUE;

        while(subtraction.hasMoreTokens()){
            int tmp = 0;

            StringTokenizer addition = new StringTokenizer(subtraction.nextToken(), "+");

            while (addition.hasMoreTokens())
                tmp += Integer.parseInt(addition.nextToken());

            if(sum == Integer.MAX_VALUE){
                sum = tmp;
            }else{
                sum -= tmp;
            }

        }
        System.out.println(sum);
    }
}
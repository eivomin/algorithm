import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringTokenizer st1 = new StringTokenizer(str, "1");
        StringTokenizer st0 = new StringTokenizer(str, "0");
        System.out.println(Math.min(st1.countTokens(), st0.countTokens()));
    }
}
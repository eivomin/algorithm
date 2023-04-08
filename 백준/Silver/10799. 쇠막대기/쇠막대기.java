import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();

        int cnt = 0;

        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                stack.push('(');
            }else if(str.charAt(i-1) == '(' && str.charAt(i) == ')'){
                // 레이저
                stack.pop();
                cnt += stack.size();
            }else if(str.charAt(i-1) == ')' && str.charAt(i) == ')'){
                // 그냥 괄호 닫는 것
                stack.pop();
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
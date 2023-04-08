import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String str = br.readLine();
            if(str.equals("."))
                break;

            Stack<Character> stack = new Stack<>();

            for(int i=0; i<str.length(); i++){
                char c = str.charAt(i);
                if(c == '('){
                    stack.push(c);
                }else if(str.charAt(i) == ')'){
                    if(stack.isEmpty() || stack.peek() != '(')
                        stack.push(c);
                    if(stack.peek() == '(')
                        stack.pop();
                }else if(str.charAt(i) == '['){
                    stack.push(c);
                }else if(str.charAt(i) == ']'){
                    if(stack.isEmpty() || stack.peek() != '[')
                        stack.push(c);
                    if(stack.peek() == '[')
                        stack.pop();
                }
            }

            if(stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
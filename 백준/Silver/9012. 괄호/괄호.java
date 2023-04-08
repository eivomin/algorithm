import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);

                if(c == '('){
                    stack.push(c);
                }else if (c == ')'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                        }else stack.push(c);
                    }else stack.push(c);
                }
            }

            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
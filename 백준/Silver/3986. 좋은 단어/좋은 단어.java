import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        for(int i=0; i<N; i++){
            String str = br.readLine();
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                if(c == 'A'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == 'A'){
                            stack.pop();
                        }else{
                            stack.push(c);
                        }
                    }else stack.push(c);
                }else if(c == 'B'){
                    if(!stack.isEmpty()){
                        if(stack.peek() == 'B'){
                            stack.pop();
                        }else{
                            stack.push(c);
                        }
                    }else stack.push(c);
                }
            }
            if(stack.isEmpty()) cnt++;
        }
        System.out.println(cnt);
    }
}
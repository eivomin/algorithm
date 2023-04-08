import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for(int i=0; i<tc; i++){
            String str = br.readLine();
            Stack<String> lstack = new Stack<>();
            Stack<String> rstack = new Stack<>();

            int len = str.length();
            for(int j=0; j<len; j++){
                String s = str.charAt(j)+"";
                if(s.equals("<")){
                    if(!lstack.isEmpty())
                        rstack.push(lstack.pop());
                }else if(s.equals(">")){
                    if(!rstack.isEmpty())
                        lstack.push(rstack.pop());
                }else if(s.equals("-")){
                    if(!lstack.isEmpty())
                        lstack.pop();
                }else{
                    lstack.push(s);
                }
            }

            StringBuilder sb = new StringBuilder();

            while(!lstack.isEmpty())
                rstack.push(lstack.pop());
            while(!rstack.isEmpty())
                sb.append(rstack.pop());

            System.out.println(sb.toString());
        }
        br.close();
    }
}
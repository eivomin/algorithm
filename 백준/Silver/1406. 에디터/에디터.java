import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<String> lstack = new Stack<>();
        Stack<String> rstack = new Stack<>();

        int len = str.length();

        for(int i=0; i<len; i++)
            lstack.add(str.charAt(i)+"");

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();
            // 명령어가 L일 경우
            if(cmd.equals("L")) {
                if(!lstack.isEmpty()){
                    rstack.push(lstack.pop());
                }
            }else if(cmd.equals("D")){
                if(!rstack.isEmpty()){
                    lstack.push(rstack.pop());
                }
            }else if(cmd.equals("B")){
                if(!lstack.isEmpty()){
                    lstack.pop();
                }
            }else {
                String s = st.nextToken();
                lstack.push(s);
            }
        }

        while(!lstack.isEmpty())
            rstack.push(lstack.pop());

        StringBuilder sb = new StringBuilder();
        while(!rstack.isEmpty())
            sb.append(rstack.pop());

        System.out.println(sb.toString());
        br.close();
    }
}
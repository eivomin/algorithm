import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            char[] command = br.readLine().toCharArray();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine();
            String str = arr.substring(1, arr.length() - 1);
            String[] arr2 = str.split(",");

            for (int j = 0; j < n; j++)
                deque.add(Integer.parseInt(arr2[j]));

            int cnt = 0;
            boolean flag = false; // 그대로
            boolean errflag = false;

            label: for (int j = 0; j < command.length; j++) {
                switch (command[j]) {
                    case 'R':
                        cnt++;
                        if (cnt % 2 == 1) { // 반대로
                            flag = true;
                        } else
                            flag = false;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            errflag = true;
                            break label;
                        }
                        if (flag) {
                            deque.pollLast();
                        } else
                            deque.pollFirst();
                        break;
                }
            }

            if (errflag) {
                System.out.println("error");
                continue;
            }

            if (deque.isEmpty()) {
                System.out.println("[]");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (!flag) { // 그대로
                while (!deque.isEmpty())
                    sb.append(deque.pollFirst() + ",");
            } else {
                while (!deque.isEmpty())
                    sb.append(deque.pollLast() + ",");
            }
            sb.delete(sb.length() - 1, sb.length());
            sb.append("]");

            System.out.println(sb);
        }
        }
    }
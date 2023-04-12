import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[][] arrA = new char[n][n];
        char[][] arrB = new char[n][n];
        
        for(int i=0; i<n; i++){
            String strA = getNum(n, arr1[i]);
            String strB = getNum(n, arr2[i]);
            arrA[i] = strA.toCharArray();
            arrB[i] = strB.toCharArray();
        }
        
        for(int i=0; i<n; i++){
            String s = "";
            for(int j=0; j<n; j++){
                if(arrA[i][j] == '1' || arrB[i][j] == '1')
                    s += "#";
                else if(arrA[i][j] == '1' && arrB[i][j] == '1')
                    s += "#";
                else
                    s += " ";
                
            }
            answer[i] = s;
        }
        
        return answer;
    }
    public static String getNum(int num, int n){
        
        Stack<Integer> stack = new Stack<>();
        
        while(n != 0){
            int mok = n/2;
            int nameoji = n%2;
            n = mok;
            stack.push(nameoji);
        }
        
        while(stack.size() != num){
            stack.push(0);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
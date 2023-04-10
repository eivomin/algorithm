import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            int a = arr[i];
            
            if(i == 0)
                stack.push(a);
            
            if(i != 0 && !stack.isEmpty()){
                if(stack.peek() == a)
                    continue;
                else
                    stack.push(a);
            }
        }
        
        int[] answer = new int[stack.size()];
        int idx = stack.size()-1;
        while(!stack.isEmpty()){
            answer[idx] = stack.pop();
            idx--;            
        }
        return answer;
    }
}
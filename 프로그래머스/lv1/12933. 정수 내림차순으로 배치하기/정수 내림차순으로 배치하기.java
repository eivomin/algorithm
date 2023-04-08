import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = Long.toString(n);
        char[] arr = str.toCharArray();
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++)
            sb.append(arr[arr.length-i-1]);
        
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}
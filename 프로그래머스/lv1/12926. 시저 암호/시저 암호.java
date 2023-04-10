import java.util.*;
class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char[] arr = s.toCharArray();
        
        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            if(c == ' ')
                answer += ' ';
            if(c >= 'a' && c <= 'z'){
                if(c+n > 'z'){
                    answer += (char) (c-26+n);
                }else{
                    answer += (char) (c+n);
                }
            }else if(c >= 'A' && c <= 'Z'){
                if(c+n > 'Z'){
                    answer += (char) (c-26+n);
                }else{
                    answer += (char) (c+n);
                }
            }
        }
        
        return answer;
    }
}
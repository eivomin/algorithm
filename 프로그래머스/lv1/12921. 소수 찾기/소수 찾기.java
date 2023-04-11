import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i=2; i<=n; i++){
            answer += isPrime(i); 
        }
        return answer;
    }
    
    public int isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
          if (n % i == 0) {
              return 0;
          }
        }
        return 1;
    }
}
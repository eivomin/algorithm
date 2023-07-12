import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static char[] arr;
    static boolean[] visited;
    
    public int solution(String numbers) {
        int answer = 0;
        
        int len = numbers.length();
        
        arr = new char[len];
        visited = new boolean[len];
        
        for(int i=0; i<len; i++)
            arr[i] = numbers.charAt(i);
        
        // 순열 만들기
        perm("", 0);
        
        answer = set.size();
        
        return answer;
    }
    
    static void perm(String str, int idx){
        int num;
        
        if(!str.equals("")){
            num = Integer.parseInt(str);
            if(isPrime(num)) set.add(num);
        }
        
        if(idx == arr.length){    
            return;
        }
        
        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                perm(str+arr[i], idx+1);
                visited[i] = false;
            }
        }
    }
    
      static boolean isPrime(int num){
        if(num==0||num==1) return false;
        for(int i=2; i*i<=num;i++){
            if(num%i==0) return false;
        }
        return true;
    }
}
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hashMap = new HashMap<>();
        
        for(String s : participant){
            if(hashMap.get(s) == null)
                hashMap.put(s, 1);
            else
                hashMap.put(s, hashMap.get(s)+1);
        }
        
        for(String s : completion){
            if(hashMap.get(s) != 0)
                hashMap.put(s, hashMap.get(s)-1);
        }
        
        for(String key : hashMap.keySet()){
            if(hashMap.get(key) != 0)
                return key;
        }
        return answer;
    }
}
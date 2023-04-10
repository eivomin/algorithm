import java.util.*;

class Solution {
    public int solution(String s) {
                int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        StringBuilder sb = new StringBuilder();
        String str = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)-48 >= 0 && s.charAt(i)-48 <= 9){
                sb.append(s.charAt(i));
            }else{
                str += s.charAt(i);
                if(map.containsKey(str)){
                    sb.append(map.get(str));
                    str = "";
                }
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
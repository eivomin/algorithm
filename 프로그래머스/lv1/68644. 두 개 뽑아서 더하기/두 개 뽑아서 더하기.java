import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int len = numbers.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++){
                set.add(numbers[i]+numbers[j]);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++)
            answer[i] = list.get(i);
        return answer;
    }
}
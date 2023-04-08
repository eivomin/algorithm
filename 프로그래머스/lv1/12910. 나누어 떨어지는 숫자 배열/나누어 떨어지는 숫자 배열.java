import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] arr, int divisor) {

ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor == 0)
                list.add(arr[i]);
        }

        Collections.sort(list);

        int[] answer = new int[list.size()];

        for(int i=0; i<answer.length; i++)
            answer[i] = list.get(i);

        if(list.size() == 0) return new int[] {-1};
        else return answer;
    }
}
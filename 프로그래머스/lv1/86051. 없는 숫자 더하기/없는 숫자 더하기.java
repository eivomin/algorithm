import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);

        int[] arr = new int[10];

        for(int i=0; i<numbers.length; i++)
            arr[numbers[i]] = numbers[i];

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0) answer += i;
        }
        return answer;
    }
}
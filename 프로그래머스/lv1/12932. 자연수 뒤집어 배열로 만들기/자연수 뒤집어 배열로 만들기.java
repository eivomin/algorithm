class Solution {
    public int[] solution(long n) {
        
        String str = Long.toString(n);
        int len = str.length();
        
        int[] answer = new int[len];
        
        for(int i=0; i<len; i++){
            answer[len-i-1] = str.charAt(i)-'0';
        }
        
        return answer;
    }
}
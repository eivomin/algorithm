class Solution {
    public boolean solution(int x) {
        String s = x+"";
        int sum = 0;
        for(int i=0; i<s.length(); i++)
            sum += (s.charAt(i)-'0');
        
        if(x%sum == 0) return true;
        else return false;
    }
}
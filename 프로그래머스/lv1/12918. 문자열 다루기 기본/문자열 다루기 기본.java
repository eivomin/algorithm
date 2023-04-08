class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        // a 97 z 122

        s = s.toLowerCase();

        int len = s.length();
        for(int i=0; i<len; i++){
            if (!(len == 4 || len == 6)) return false;
            if(s.charAt(i) >= 97 && s.charAt(i) <= 122) return false;
        }
        return true;
    }
}
class Solution {
    public int[] solution(int n, int m) {

        int min = Math.min(n,m);
        int gcd = 0;
        
        for(int i=1; i<=min; i++){
            if(n%i == 0 && m%i == 0)
                gcd = i;
        }
        return new int[] {gcd, n*m/gcd};
    }
}
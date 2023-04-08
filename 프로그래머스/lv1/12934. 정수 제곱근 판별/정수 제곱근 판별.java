class Solution {
    public long solution(long n) {
        long target = (long) Math.sqrt(n);
        if(target*target != n) return -1;
        return (long)Math.pow(target+1,2);
    }
}
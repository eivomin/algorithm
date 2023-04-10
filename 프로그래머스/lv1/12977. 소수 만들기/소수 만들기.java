class Solution {
    static int[] sel = new int[3];
    static int total = 0;
    public int solution(int[] nums) {

        // 3개 뽑기 조합
        combination(nums,0,0);
        // 소수 만들기 함수 
        return total;
    }
        private static void combination(int[] nums, int idx, int s_idx){
        if(s_idx == sel.length){
            total += isPrime(sel);
            return;
        }
        for(int i=idx; i<nums.length; i++){
            sel[s_idx] = nums[i];
            combination(nums,i+1, s_idx+1);
        }
    }

    private static int isPrime(int[] sel) {
        /*[1, 2, 3]
            [1, 2, 4]
            [1, 3, 4]
            [2, 3, 4]
            */
        int sum = 0;
        for(int a : sel) sum += a;
        for(int i=2; i<=(int)Math.sqrt(sum); i++){
            if(sum % i == 0)
                return 0;
        }
        return 1;
    }
}
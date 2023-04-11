import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int len = nums.length;
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<nums.length; i++)
            set.add(nums[i]);
        
        // 1 2 3 
        
        int cnt = len/2;
        
        ArrayList<Integer> list = new ArrayList<>();
        
        Iterator<Integer> iter = set.iterator();
        
        while(iter.hasNext())
            list.add(iter.next());
        
        Collections.sort(list);
        
        // 1 2 3 -- 2
        // 2 3 4 -- 3
        // 2 3 -- 3
        
        if(list.size() < cnt) answer = list.size();
        else answer = cnt;
        
        
        return answer;
    }
}
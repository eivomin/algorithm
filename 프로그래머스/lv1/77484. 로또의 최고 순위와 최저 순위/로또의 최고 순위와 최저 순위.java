import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for(int i=0; i<win_nums.length; i++)
            set.add(win_nums[i]);
        
        int cnt = 0;
        int plus = 0;
        for(int i=0; i<lottos.length; i++){
            if(set.contains(lottos[i])) cnt++;
            if(lottos[i] == 0) plus++;            
        }
        
        int min = 6;        
        // 당첨 순위
        if(cnt < 2) min = 6;
        else if(cnt == 2) min = 5;
        else if(cnt == 3) min = 4;
        else if(cnt == 4) min = 3;
        else if(cnt == 5) min = 2;
        else if(cnt == 6) min = 1;
        
        int max = 1;
        // 당첨 순위
        if(cnt+plus < 2) max = 6;
        else if(cnt+plus == 2) max = 5;
        else if(cnt+plus == 3) max = 4;
        else if(cnt+plus == 4) max = 3;
        else if(cnt+plus == 5) max = 2;
        else if(cnt+plus == 6) max = 1;
        
        return new int[] { max,min};
    }
}
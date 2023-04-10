import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int xmax = 1;
        int ymax = 1;
        
        for(int i=0; i<sizes.length; i++){
            int x = Math.max(sizes[i][0], sizes[i][1]);
            int y = Math.min(sizes[i][0], sizes[i][1]);
            xmax = Math.max(xmax, x);
            ymax = Math.max(ymax, y);
        }
        return xmax*ymax;
    }

}
import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
      Stack<Integer> stack = new Stack<>();
        int len = board.length;

        int doll = -1;
        int answer = 0;

        for(int k=0; k<moves.length; k++){
            int target = moves[k];
            boolean flag = false;

            for(int i=0; i<len; i++){
                if(board[i][target-1] != 0){
                    // 뽑음
                    doll = board[i][target-1];
                    board[i][target-1] = 0;
                    flag = true;
                    break;
                }
            }

            if(flag){
                if(!stack.isEmpty()){
                    if(stack.peek() == doll){
                        answer++;
                        stack.pop();
                    }else stack.push(doll);
                }else stack.push(doll);
            }
        }
        return answer*2;
    }
}
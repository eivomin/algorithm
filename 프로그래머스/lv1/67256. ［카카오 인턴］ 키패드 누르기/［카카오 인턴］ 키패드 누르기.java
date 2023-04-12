import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        ArrayList<Keypad> list = new ArrayList<>();
        list.add(new Keypad(0, 3, 1));
        list.add(new Keypad(1, 0, 0));
        list.add(new Keypad(2, 0, 1));
        list.add(new Keypad(3, 0, 2));
        list.add(new Keypad(4, 1, 0));
        list.add(new Keypad(5, 1, 1));
        list.add(new Keypad(6, 1, 2));
        list.add(new Keypad(7, 2, 0));
        list.add(new Keypad(8, 2, 1));
        list.add(new Keypad(9, 2, 2));
        list.add(new Keypad(10, 3, 0)); // left 시작점 *
        list.add(new Keypad(11, 3, 2)); // right 시작점 #

        int leftNum = 10;
        int rightNum = 11;

        for(int i=0; i<numbers.length; i++){
            // 왼손 1 4 7
            if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                sb.append("L");
                leftNum = numbers[i];
            }
            // 오른손 3 6 9
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                sb.append("R");
                rightNum = numbers[i];
            }
            // 2 5 8 0
            else{
                // 5일 때
                int leftX = list.get(leftNum).x;
                int leftY = list.get(leftNum).y;
                int curX = list.get(numbers[i]).x;
                int curY = list.get(numbers[i]).y;
                int rightX = list.get(rightNum).x;
                int rightY = list.get(rightNum).y;

                int leftLen = Math.abs(leftX-curX)+Math.abs(leftY-curY);
                int rightLen = Math.abs(rightX-curX)+Math.abs(rightY-curY);

                if(leftLen > rightLen) {
                    sb.append("R");
                    rightNum = numbers[i];
                }
                else if(leftLen < rightLen){
                    sb.append("L");
                    leftNum = numbers[i];
                }
                else if(leftLen == rightLen){
                    if(hand.equals("left")){
                        sb.append("L");
                        leftNum = numbers[i];
                    }
                    else{
                        sb.append("R");
                        rightNum = numbers[i];
                    }
                }

            }
        }
        return sb.toString();
    }
        static class Keypad{
        int idx;
        int x;
        int y;
        public Keypad(int idx, int x, int y){
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
}
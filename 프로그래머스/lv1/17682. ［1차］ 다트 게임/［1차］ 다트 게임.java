class Solution {
    public int solution(String dartResult) { 
        int[] score = new int[3];
        String str = "";
        int idx = 0;
        
        for(int i=0; i<dartResult.length(); i++){
            char c = dartResult.charAt(i);
            // 숫자일 때
            if(c >= '0' && c <= '9')
                str += c;
            // S, D, T 일 때
            else if(c == 'S' || c == 'D' || c == 'T'){
                int num = Integer.parseInt(str);
                if(c == 'S'){
                    score[idx++] = (int)Math.pow(num,1);
                }else if(c == 'D'){
                    score[idx++] = (int)Math.pow(num,2);
                }else if(c == 'T'){
                    score[idx++] = (int)Math.pow(num,3);
                }
                str = "";
            }
            // * # 일 때
            else {
                if(c == '*'){
                    score[idx-1] *= 2;
                    if(idx-2>=0) score[idx-2] *= 2;
                }
                else{
                    score[idx-1] *= (-1);
                }
            }
        }
        return score[0]+score[1]+score[2];
    }
}
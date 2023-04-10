class Solution {
    public String solution(String new_id) {
               String answer = "";
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        for(int i=0; i<new_id.length(); i++){
            char c = new_id.charAt(i);
            if((c >= 97 && c <= 122) || (c >= 48 && c <= 57) || c == '-' || c == '_' || c == '.')
                answer += c;
        }

        // 3단계
        while(true){
            String str = answer;
            answer = answer.replace("..", ".");
            if(str.equals(answer)) break;
        }

        // 4단계
        if(answer.charAt(0) == '.')
            answer = answer.substring(1, answer.length());
        if(answer.length()  != 0 && answer.charAt(answer.length()-1) == '.')
            answer = answer.substring(0, answer.length()-1);

        // 5단계
        if(answer.length() == 0)
            answer = "a";

        // 6단계
        if(answer.length() >= 16){
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.') answer = answer.substring(0,14);
        }

        // 7단계
        if(answer.length() <= 2){
            while(true){
                if(answer.length() == 3)
                    break;
                answer += answer.charAt(answer.length()-1);
            }
        }
        return answer;
    }
}
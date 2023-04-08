class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        int cnt = arr.length; // 단어 개수

        int idx = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append(" ");
            }else{
                String str = "";
                for(int j=0; j<arr[idx].length(); j++){
                    str += arr[idx].charAt(j)+"";
                }
                sb.append(getWord(str));
                i += arr[idx].length()-1;
                idx++;
            }
        }
        return sb.toString();
    }
    
        public static String getWord(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            if(i%2 == 0)
                sb.append((str.charAt(i)+"").toUpperCase());
            else
                sb.append((str.charAt(i)+"").toLowerCase());
        }
        return sb.toString();

    }
}
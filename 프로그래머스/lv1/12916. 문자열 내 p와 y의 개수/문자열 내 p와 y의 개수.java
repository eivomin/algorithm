class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int[] arr = new int[26];
        // a b c d e f g h i j k l m n o p q r s t u v w x y z

        s = s.toLowerCase();

        for(int i=0; i<s.length(); i++)
            arr[s.charAt(i)-97]++;

        return (arr[15] == arr[24]) ? true : false;
    }
}
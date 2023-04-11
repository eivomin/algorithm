import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Arrays.sort(stages);
        ArrayList<Stage> list = new ArrayList<>();
        // 1 2 2 2 3 3 4 6
        for(int i=1; i<=N; i++){
            int total = 0;
            int fail = 0;
            for(int j=0; j<stages.length; j++){
                if(stages[j] >= i) total++;
                if(stages[j] <= i && stages[j] > (i-1)) fail++;
            }
            list.add(new Stage(i, (double)fail/total));
        }

        Collections.sort(list, new Comparator<Stage>() {
            @Override
            public int compare(Stage o1, Stage o2) {
                if(o1.rate < o2.rate)
                    return 1;
                else if(o1.rate > o2.rate)
                    return -1;
                else{
                    return o1.idx - o2.idx;
                }
            }
        });

        int[] answer = new int[N];

        for(int i=0; i<N; i++)
            answer[i] = list.get(i).idx;

        return answer;
    }
    
    static class Stage{
        int idx;
        double rate;
        public Stage(int idx, double rate){
            this.idx = idx;
            this.rate = rate;
        }
    }
}
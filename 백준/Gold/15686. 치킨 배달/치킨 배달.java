import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, homeCnt, chickenCnt;
    static int[][] map;
    static ArrayList<Pair> homeList, chickenList;
    static int[] tmp;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        tmp = new int[M];
        homeList = new ArrayList<>();
        chickenList = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1)
                    homeList.add(new Pair(i,j));
                else if(map[i][j] == 2)
                    chickenList.add(new Pair(i,j));
            }
        }

        homeCnt = homeList.size();
        chickenCnt = chickenList.size();

        combination(0, 0); // 치킨집에서 M개 뽑을 조합

        System.out.println(result);
    }

    private static void combination(int idx, int s_idx) {
        if(s_idx == M){
            result = Math.min(result, getDistance());
            return;
        }

        for(int i=idx; i<chickenCnt; i++){
            tmp[s_idx] = i;
            combination(i+1, s_idx+1);
        }
    }

    private static int getDistance() {
        int total = 0;
        for(int i=0; i<homeCnt; i++){
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < M; j++) {
                min = Math.min(min, Math.abs((homeList.get(i).x - chickenList.get(tmp[j]).x))
                        + Math.abs((homeList.get(i).y - chickenList.get(tmp[j]).y)));
            }
            total += min;
        }
        return total;
    }

    static class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] B;
    static int[][] board;
    static int max = 0;
    static int N;
    static int[] output;
    static LinkedList<Integer> boardList;
    static LinkedList<Integer> num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        B = new int[N][N];
        output = new int[5];

        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<N; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        perm(0);

        System.out.println(max);

    }

    private static void perm(int idx) {
        if(idx == 5){ // 최대 5번의 결과를 모두 얻은 경우
            moveBlock();
            return;
        }
        for(int i=0; i<4; i++){
            output[idx] = i;
            perm(idx+1);
        }

    }

    // 블록이 합쳐지기 전 방향에 따라 블록 모아주는 함수
    private static void moveBlock() {
        // 블록 이동 결과를 저장하기 위해 초기 보드 배열을 깊은 복사함
        board = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                board[i][j] = B[i][j];
            }
        }

        for(int i=0; i<output.length; i++){
            long dir = output[i]; // 방향 값 저장 변수 (0: 상 / 1: 하 / 2: 좌 / 3: 우)
            for(int j=0; j<N; j++){
                boardList = new LinkedList<>();
                for(int k=0; k<N; k++){
                    if(dir == 0 || dir == 1){ // 위, 왼쪽일 경우 한 행과 열의 블록 값이 왼쪽 방향으로 모아짐
                        boardList.add(board[k][j]);
                    }else{ // 아래, 오른쪽일 경우 한 행과 열의 블록 값이 오른쪽 방향으로 모아짐
                        boardList.add(board[j][k]);
                    }
                }

                for(int k=0; k<boardList.size(); k++){ // 중간의 '0' 빈 블록을 제거하기 위한 과정
                    if(boardList.get(k) == 0){
                        boardList.remove(k);
                        k--;
                    }
                }

                // 이동하며 0을 삭제한 만큼 왼쪽 오른쪽에 0 채워주기
                if(dir == 0 || dir == 2){
                    while(boardList.size() != N)
                        boardList.addLast(0);
                }else{
                    while(boardList.size() != N)
                        boardList.addFirst(0);
                }

                // board에 이동 완료한 값 넣어주기
                if(dir == 0 || dir == 1){
                    for(int k=0; k<N; k++)
                        board[k][j] = boardList.get(k);
                }else{
                    for(int k=0; k<N; k++)
                        board[j][k] = boardList.get(k);
                }
            }
            // 이동한 보드를 바탕으로 합치기
            mergeBlock(dir);

            // 최대 5번 모두 블록을 이동하고 합친 후 가장 큰 값을 얻음
            if(i == output.length-1)
                getMax();
        }
    }

    private static void mergeBlock(long dir) {
        // 한 줄씩 merge 해주기 위해 값 가져와서 LinkedList에 저장
        for(int i=0; i<N; i++){
            num = new LinkedList<>();

            for(int j=0; j<N; j++){
                if(dir == 0 || dir == 1){
                    num.add(board[j][i]);
                }else{
                    num.add(board[i][j]);
                }
            }

            //merge
            if(dir == 0 || dir == 2){ // 위쪽과 왼쪽의 경우 앞부터 합쳐짐
                for(int k=0; k < num.size()-1; k++){
                    if(!num.get(k).equals(0) && num.get(k).equals(num.get(k+1))){
                        int val = num.get(k)*2;
                        num.remove(k);
                        num.remove(k);
                        num.add(k, val);
                    }
                }
            }else{ // 아래쪽과 오른쪽의 경우 뒤부터 합쳐짐
                for(int k = num.size()-1; k > 0; k--){
                    if(!num.get(k).equals(0) && num.get(k).equals(num.get(k-1))){
                        int val = num.get(k)*2;
                        num.remove(k);
                        num.remove(k-1);
                        num.add(k-1, val);
                        k--; // 삭제해주고 새로운 합쳐진 값을 넣어줬기 때문에 그 다음 인덱스부터 시작하기 위해 -1
                    }
                }
            }

            // merge 과정에서 줄어든 자리수 맞춰 주기
            if(dir == 0 || dir == 2){
                while(num.size() != N)
                    num.addLast(0);
            }else{
                while(num.size() != N)
                    num.addFirst(0);
            }

            // merge한 값 배열에 넣어주기
            if(dir == 0 || dir == 1){
                for(int k=0; k<N; k++){
                    board[k][i] = num.get(k);
                }
            }else{
                for(int k=0; k<N; k++){
                    board[i][k] = num.get(k);
                }
            }
        }
    }

    // 보드판에서 가장 큰 수의 블록을 찾는 함수
    private static void getMax() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++)
                max = Math.max(board[i][j], max);
        }
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr;
    static int N;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    private static void nQueen(int depth) {
        if(depth == N){
            count++;
            return;
        }

        for(int i=0; i<N; i++){
            arr[depth] = i;
            // 놓을 수 있는 위치일 경우 호출
            if(Possibility(depth)){
                nQueen(depth+1);
            }
        }
    }

    private static boolean Possibility(int col) {
        for(int i=0; i<col; i++){
            // 해당 열의 행과 i열의 행이 일치할 경우 (같은 행에 존재할 경우)
            if (arr[col] == arr[i]){
                return false;
            }
            // 대각선상에 놓여있는 경우 (행과 열의 차이가 같을 경우)
            else if (Math.abs(col - i) == Math.abs(arr[col]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
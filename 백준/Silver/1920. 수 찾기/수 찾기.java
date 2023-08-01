import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int[] target = new int[M];

        for(int i=0; i<M; i++)
            target[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            if(binarySearch(arr, target[i]) >= 0) System.out.println(1);
            else System.out.println(0);
        }

    }

    private static int binarySearch(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length-1;

        while (lo <= hi){
            int mid = (lo+hi)/2;

            if(key < arr[mid]){
                hi = mid-1;
            }else if(key > arr[mid]){
                lo = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
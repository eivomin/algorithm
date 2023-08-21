import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<String, String> hashMap = new HashMap<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String keyword = st.nextToken();

            if(hashMap.containsKey(name)){
                hashMap.remove(name);
            }else {
                hashMap.put(name, keyword);
            }
        }

        ArrayList<String> list = new ArrayList<>(hashMap.keySet());
        Collections.sort(list, Collections.reverseOrder());

        list.stream()
                .forEach(System.out::println);

    }
}
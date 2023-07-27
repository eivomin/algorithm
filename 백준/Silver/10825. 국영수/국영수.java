import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, ((o1, o2) -> {
            if(o2.korean > o1.korean)
                return 1;
            else if(o2.korean == o1.korean){
                if(o1.english > o2.english)
                    return 1;
                else if(o1.english == o2.english){
                    if(o1.math < o2.math){
                        return 1;
                    }
                    else if(o1.math == o2.math){
                        return o1.name.compareTo(o2.name);
                    }
                }
            }
            return -1;
        }));

        list.forEach(student -> System.out.println(student.name));

    }

    static class Student{
        String name;
        int korean, english, math;
        public Student(String name, int korean, int english, int math){
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
}
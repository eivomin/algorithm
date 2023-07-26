import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Person> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            list.add(new Person(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        list.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .forEach(person -> System.out.println(person.getAge()+" "+person.getName()));
    }

    static class Person{
        int idx;
        int age;
        String name;
        public Person(int idx, int age, String name){
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        public int getIdx(){
            return idx;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
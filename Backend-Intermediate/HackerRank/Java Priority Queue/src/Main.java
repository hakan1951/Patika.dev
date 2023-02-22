import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static Scanner sc = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int numberOfEvents = Integer.parseInt(sc.nextLine());
        List<String> eventList = new ArrayList<>();

        while (numberOfEvents-- != 0) {
            String inputLine = sc.nextLine();
            eventList.add(inputLine);
        }

        List<Student> students = priorities.getStudents(eventList);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }
}
    class Priorities{
        private final PriorityQueue<Student> pq = new PriorityQueue<>(
                Comparator.comparing(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getId));

        public List<Student> getStudents(List<String> events) {
            for (String s : events){
                if (s.equals("SERVED")) {
                    pq.poll();
                } else {
                    String[] values = s.split(" ");
                    pq.add(new Student((values[1]), Double.parseDouble(values[2]), Integer.parseInt(values[3])));
                }
            }

            List<Student> students = new ArrayList<>();
            while (!pq.isEmpty()) {
                students.add(pq.poll());
            }

            return students;
        }
    }
     class Student {
        private final String name;
        private final double cgpa;
        private final int id;

        public Student(String name, double cgpa, int id) {
            this.name = name;
            this.cgpa = cgpa;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCgpa() {
            return cgpa;
        }
    }

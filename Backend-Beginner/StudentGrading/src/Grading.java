public class Grading {
    public static void main(String[] args) {
        Course math = new Course("Mathematics", "MATH101", "MATH");
        Course physics = new Course("Physics", "PHYS101", "PHYS");
        Course chemistry = new Course("Chemistry", "CHEM101", "CHEM");

        Teacher t1 = new Teacher("Mahmut Hoca", "90550000000", "MATH");
        Teacher t2 = new Teacher("Fatma Ayşe", "90550000001", "PHYS");
        Teacher t3 = new Teacher("Ali Veli", "90550000002", "CHEM");

        math.addTeacher(t1);
        physics.addTeacher(t2);
        chemistry.addTeacher(t3);

        Student s1 = new Student("İnek Şaban", 4, "140144015", math, physics, chemistry);
        s1.addExamGrades(100, 90,20, 20,70,70);
        s1.isPass();

        Student s2 = new Student("Güdük Necmi", 4, "2211133", math, physics, chemistry);
        s2.addExamGrades(50,80,70,30,40,60);
        s2.isPass();

        Student s3 = new Student("Hayta İsmail", 4, "221121312", math, physics, chemistry);
        s3.addExamGrades(50,50,20,20,50,40);
        s3.isPass();
    }
    public static class Course {
        Teacher courseTeacher;
        String name;
        String code;
        String prefix;
        int grade;
        int verbalGrade;
        double weightedGrade;

        public Course(String name, String code, String prefix) {
            this.name = name;
            this.code = code;
            this.prefix = prefix;
            this.grade = 0;
            this.verbalGrade = 0;
            this.weightedGrade = 0;
        }

        public void addTeacher(Teacher t) {
            if (this.prefix.equals(t.department)) {
                this.courseTeacher = t;
                System.out.println("Teacher is added.");
            } else {
                System.out.println(t.name + " can not lecture this course.");
            }
        }

        public void printTeacher() {
            if (courseTeacher != null) {
                System.out.println(this.name + " is lectured by : " + courseTeacher.name);
            } else {
                System.out.println(this.name + " has no lecturer assigned.");
            }
        }
    }
    public static class Student {
        String name, id;
        int classes;
        Course mathematics;
        Course physics;
        Course chemistry;
        double average;
        boolean isPassed;

        Student(String name, int classes, String id, Course mathematics, Course physics, Course chemistry) {
            this.name = name;
            this.classes = classes;
            this.id = id;
            this.mathematics = mathematics;
            this.physics = physics;
            this.chemistry = chemistry;
            calcAverage();
            this.isPassed = false;
        }
        public void addExamGrades(int mathGrade, int mathVerbalGrade, int physGrade, int physVerbalGrade, int chemGrade, int chemVerbalGrade) {

            if (isRange(mathGrade) && isRange(mathVerbalGrade)) {
                this.mathematics.grade = mathGrade;
                this.mathematics.verbalGrade = mathVerbalGrade;
                this.mathematics.weightedGrade = (double) mathGrade * 0.20 + (double)mathVerbalGrade * 0.80;
            }
            if (isRange(physGrade) && isRange(physVerbalGrade)) {
                this.physics.grade = physGrade;
                this.physics.verbalGrade = physVerbalGrade;
                this.physics.weightedGrade = (double)physGrade * 0.20 + (double)physVerbalGrade * 0.80;

            }
            if (isRange(chemGrade) && isRange(chemVerbalGrade)) {
                this.chemistry.grade = chemGrade;
                this.chemistry.verbalGrade = chemVerbalGrade;
                this.chemistry.weightedGrade = (double)chemGrade * 0.20 + (double)chemVerbalGrade * 0.80;

            }
        }
        public boolean isRange(int grade){
            return (grade >= 0 && grade <= 100);
        }

        public void isPass() {
            if (this.mathematics.grade == 0 || this.mathematics.verbalGrade == 0
                    || this.physics.grade == 0 || this.physics.verbalGrade == 0
                    || this.chemistry.grade == 0 || this.chemistry.verbalGrade == 0) {
                System.out.println("Missing grades.");
            } else {
                this.isPassed = isCheckPass();
                printNote();
                System.out.format("Gpa: %.2f\n", this.average);
                if (this.isPassed) {
                    System.out.println("Class is passed. ");
                } else {
                    System.out.println("Class is failed.");
                }
            }
        }
        public void calcAverage() {
            this.average = ((mathematics.weightedGrade)
                    + (physics.weightedGrade)
                    + (chemistry.weightedGrade)) / 3;
        }
        public boolean isCheckPass() {
            calcAverage();
            return this.average > 55;
        }
        public void printNote(){
            System.out.println("=========================");
            System.out.println("Student: " + this.name);
            System.out.format("Mathematics grade: %.2f\n", this.mathematics.weightedGrade);
            System.out.format("Physics grade: %.2f\n", this.physics.weightedGrade);
            System.out.format("Chemistry grade: %.2f\n", this.chemistry.weightedGrade);
        }
    }
    public static class Teacher {
        String name;
        String phoneNumber;
        String department;

        public Teacher(String name, String phoneNumber, String department) {
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.department = department;
        }

    }
}
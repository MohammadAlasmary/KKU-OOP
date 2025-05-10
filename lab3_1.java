import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}

class Student extends Person {
    private static final int MAX_COURSES = 30;
    private int numCourses;
    private String[] courses;
    private int[] grades;

    public Student(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_COURSES];
        this.grades = new int[MAX_COURSES];
    }

    public void addCourseGrade(String course, int grade) {
        if (numCourses < MAX_COURSES) {
            this.courses[numCourses] = course;
            this.grades[numCourses] = grade;
            numCourses++;
        } else {
            System.out.println("Student " + getName() + " has reached the maximum number of courses.");
        }
    }

    public void printGrades() {
        System.out.println("Grades for Student: " + getName());
        for (int i = 0; i < numCourses; i++) {
            System.out.println("Course: " + courses[i] + ", Grade: " + grades[i]);
        }
    }

    public double getAverageGrade() {
        if (numCourses == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int i = 0; i < numCourses; i++) {
            sum += grades[i];
        }
        return (double) sum / numCourses;
    }

    @Override
    public String toString() {
        return "Student: " + super.toString() + ", Number of Courses: " + numCourses;
    }
}

class Teacher extends Person {
    private static final int MAX_COURSES_TAUGHT = 5;
    private int numCourses;
    private String[] courses;

    public Teacher(String name, String address) {
        super(name, address);
        this.numCourses = 0;
        this.courses = new String[MAX_COURSES_TAUGHT];
    }

    public boolean addCourse(String course) {
        if (numCourses < MAX_COURSES_TAUGHT) {
            for (int i = 0; i < numCourses; i++) {
                if (courses[i].equals(course)) {
                    return false;
                }
            }
            this.courses[numCourses++] = course;
            return true;
        } else {
            System.out.println("Teacher " + getName() + " has reached the maximum number of courses they can teach.");
            return false;
        }
    }

    public boolean removeCourse(String course) {
        for (int i = 0; i < numCourses; i++) {
            if (courses[i].equals(course)) {
                for (int j = i; j < numCourses - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[numCourses - 1] = null;
                numCourses--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Teacher: " + super.toString() + ", Courses Taught: " + Arrays.toString(Arrays.copyOfRange(courses, 0, numCourses));
    }
}

public class SchoolManagement {
    public static void main(String[] args) {

        Student student1 = new Student("Alice Smith", "123 Main St");
        student1.addCourseGrade("Math 101", 90);
        student1.addCourseGrade("Science 201", 85);
        student1.addCourseGrade("English 101", 92);
        System.out.println(student1);
        student1.printGrades();
        System.out.println("Average Grade: " + student1.getAverageGrade());
        System.out.println();

        Student student2 = new Student("Bob Johnson", "456 Oak Ave");
        student2.addCourseGrade("History 101", 78);
        student2.addCourseGrade("Computer Science 101", 95);
        System.out.println(student2);
        student2.printGrades();
        System.out.println("Average Grade: " + student2.getAverageGrade());
        System.out.println();


        Teacher teacher1 = new Teacher("Charlie Brown", "789 Pine Ln");
        teacher1.addCourse("Math 101");
        teacher1.addCourse("Physics 201");
        teacher1.addCourse("Chemistry 201");
        System.out.println(teacher1);
        teacher1.removeCourse("Physics 201");
        System.out.println(teacher1);
        teacher1.addCourse("Biology 101");
        teacher1.addCourse("Calculus 201");
        teacher1.addCourse("Statistics 101");
        System.out.println(teacher1);
        System.out.println();

        Teacher teacher2 = new Teacher("Diana Miller", "101 Elm St");
        teacher2.addCourse("English 101");
        teacher2.addCourse("Literature 201");
        teacher2.addCourse("Creative Writing 101");
        System.out.println(teacher2);
        System.out.println();
    }
}

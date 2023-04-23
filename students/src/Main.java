import java.util.Scanner;

public class Main { 
    static Scanner scanner = new Scanner(System.in);
    static Student[] students;

    public static void initTui() {
        System.out.println("Quants estudiants vols afegir?");
        int n = scanner.nextInt();
        students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Introdueix el nom de l'estudiant " + (i + 1) + ":");
            String name = scanner.next();
            System.out.println("Introdueix l'edat de l'estudiant " + (i + 1) + ":");
            int age = scanner.nextInt();
            System.out.println("Introdueix el número d'assignatures matriculades de l'estudiant " + (i + 1) + ":");
            int numSubjects = scanner.nextInt();
            students[i] = new Student(name, age, numSubjects);
        }
    }

    public static void printStudents() {
        System.out.println("Llista d'estudiants:");
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }

    public static void main(String[] args) {
        initTui();
        printStudents();
    }
}

class Student {
    private String name;
    private int age;
    private int numSubjects;

    public Student(String name, int age, int numSubjects) {
        this.name = name;
        this.age = age;
        this.numSubjects = numSubjects;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getNumSubjects() {
        return numSubjects;
    }

    public String toString() {
        return "Nom: " + name + ", Edat: " + age + ", Assignatures: " + numSubjects;
    }
}

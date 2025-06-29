

/*
Задание 1

Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.+
Создайте коллекцию, содержащую объекты класса Student.+

Следует написать метод, который удаляет студентов со средним баллом < 3,+
а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3. +

Напишите метод printStudents(Set<Student> students, int course),
который получает список студентов и номер курса.+

Метод печатает на консоль имена тех студентов,
которые обучаются на данном курсе.+

Задание 2

Написать простой класс Телефонный Справочник,
который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
 */


import java.util.HashSet;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        var students = new HashSet<Student>();

        for (int i = 0; i < 10; i++) {
            //создаю символы для имени студента
            var arr = new char[]{
                    (char) (65 + new Random().nextInt(25)),
                    (char) (97 + new Random().nextInt(25)),
                    (char) (97 + new Random().nextInt(25)),
                    (char) (32),
                    (char) (65 + i),
                    (char) (65 + i*2)
            };

            Student student = new Student(
                    new String(arr),
                    "group_" + 1 + i,
                    1 + new Random().nextInt(4));
            students.add(student);
        }

        students.forEach(student -> {
            for (var subject : Subject.values()) {
                int randomGrade = new Random().nextInt(3) + 2;
                student.setGrades(subject, randomGrade);
            }
        });
        System.out.println("список студентов");
        students.stream().forEach(student->{
            System.out.print(student.getName() + " " + student.getCourse()+" курс, ");
        });
        System.out.println("\n_________________________");

        DeansOfficeService deansOffice = new DeansOfficeService("Нормальный факультет");

        Student[] expelledStudent = deansOffice.removeStudentsWithLowAverageGrade(students);
        System.out.println("Отчислены: ");
        for (Student student : expelledStudent) {
            System.out.println(student.getName());
        }
        System.out.println("_________________________");
        Student[] promoteStudent = deansOffice.checkAndPromoteStudent(students);
        System.out.println("перевели на след. курс: ");
        for (Student student : promoteStudent) {
            System.out.println(student.getName());
        }
        System.out.println("_________________________");

        System.out.println("первокурсники: ");
        deansOffice.printStudents(students,1);
        System.out.println("второкурсники: ");
        deansOffice.printStudents(students,2);
        System.out.println("третьекурсники: ");
        deansOffice.printStudents(students,3);
        System.out.println("четверокурсники: ");
        deansOffice.printStudents(students,4);
        System.out.println("пятикурсники: ");
        deansOffice.printStudents(students,5);

    }
}

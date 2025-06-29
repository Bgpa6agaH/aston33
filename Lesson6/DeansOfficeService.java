

import java.util.LinkedList;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;


public class DeansOfficeService {

    String faculty;

    //метод, который удаляет студентов со средним баллом < 3,
    public Student[] removeStudentsWithLowAverageGrade(Set<Student> students) {

        Student[] expelledStudent = students.stream()
                .filter(student -> student.getAVGGrades() < 3) // Фильтруем тех, кого исключаем
                .toArray(Student[]::new);

        students.removeIf(student->student.getAVGGrades()<3);
        return expelledStudent;

    }
//а также отдельный метод, который переводит студента на следующий курс, если средний балл >= 3.
    public Student[] checkAndPromoteStudent(Set<Student> students) {
        var promoteStudent = new LinkedList<Student>();
        students.forEach( student -> {
            double avg = student.getAVGGrades();
            if (avg>=3){
                student.setCourse(student.getCourse()+1);
                promoteStudent.add(student);
            }
                }
        );
        return promoteStudent.toArray(Student[]::new);
    }

//Напишите метод printStudents(Set<Student> students, int course),
//который получает список студентов и номер курса.
    public void printStudents(Set<Student> students, int course){
        students.stream()
                .filter(student -> student.getCourse()==course)
                .map(Student::getName)
                .forEach(System.out::println);
    }

    public DeansOfficeService(String faculty) {
        this.faculty = faculty;
    }



    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}

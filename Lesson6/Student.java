import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;

//Создайте класс Student, содержащий следующие характеристики – имя, группа, курс, оценки по предметам.
public class Student {

    private String name;
    private String group;
    private int course;
    private Map<Subject,Integer> subjectGrades;

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        subjectGrades = new HashMap<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setSubjectGrades(Map<Subject, Integer> subjectGrades) {
        this.subjectGrades = subjectGrades;
    }

    public void setGrades(Subject subject, int randomGrade) {
        subjectGrades.put(subject,randomGrade);
    }

   // OptionalDouble avg =  student.getSubjectGrades().values().stream().mapToInt(Integer::intValue).average();
    public double getAVGGrades(){
       return subjectGrades
               .values()
               .stream()
               .mapToInt(Integer::intValue)
               .average()
               .orElse(0.0);
    }



    public String getName() {
        return name;
    }
    public String getGroup() {
        return group;
    }

    public int getCourse() {
        return course;
    }

    public Map<Subject, Integer> getSubjectGrades() {
        return subjectGrades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", subjectGrades=" + subjectGrades +
                '}';
    }
}

package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().filter(grade -> grade.getType().getValue() == 100).count() > 0;
    }


    public static List<Integer> getStudentAges(List<Student> students) {
        return students.stream().map(student -> student.getAge()).toList();
    }

    public static List<Student> getStudentsWithMinimumAge(List<Student> students, int minAge) {
        return students.stream().filter(student -> student.getAge() >= minAge).toList();
    }


    // getGender() == Gender.MALE
    // or getGender().name().equals("MALE")
    public static long countMaleStudents(List<Student> students) {
        return students.stream().filter(student -> student.getGender() == Gender.MALE).count();
    }


    public static double avgAgeOfFemaleStudent(List<Student> students) {
        int sum = students.stream().filter(student -> student.getGender() == Gender.FEMALE).map(Student::getAge).reduce(Integer::sum).orElse(0);
        long femaleCount = students.stream().filter(student -> student.getGender() == Gender.FEMALE).count();
        return  (double) sum / femaleCount;
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().mapToInt(Student::getAge).sum();
    }

    // ignore F Grades
    public static double productOfStudentGrades(Student student) {
        return student.getGrades().stream().mapToDouble(students -> students.getType().getValue()).sum();
    }

    // region BONUS

    public static Optional<Grade> getBestMathGradeFromStudent(Student student) {
        return Optional.empty();
    }

    public static List<Integer> getSortedAges(List<Student> students) {
        return new ArrayList<>();
    }

    // endregion
}

package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DataProcessor {


    public static boolean atLeastOneGradeA(Student student) {
        return student.getGrades().stream().anyMatch(grade -> grade.getType().getValue() == 100);
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
        return students.stream().filter(student -> student.getGender() == Gender.FEMALE).mapToDouble(Student::getAge).average().orElse(Double.NaN);
    }

    public static Integer getProductOfStudentAges(List<Student> students) {
        return students.stream().mapToInt(student -> student.getAge()).reduce(1, (res, studentAge) -> studentAge * res);
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

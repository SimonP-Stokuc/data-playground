package processing

import streams.*

fun sumOfAgesOfAllStudents(school: School): Int {
    return school.classes.asSequence().flatMap { it.students }.sumOf { it.age }
}

fun allStudentsWithAgeGreaterThan(school: School, minAge: Int): List<Student> {
    return school.classes.asSequence().flatMap { it.students }.filter { student -> student.age > minAge }.toList()
}

fun avgMathGradeForAllFemaleStudents(school: School): Double {
    return school.classes.asSequence().flatMap { it.students }.filter { student -> student.gender == Gender.FEMALE }.flatMap { it.grades }.filter { grade -> grade.subject == Subject.MATH }.map { grade ->  grade.type.value}.average()
}


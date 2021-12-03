package processing

import streams.*


fun atLeastOneGradeA(student: Student): Boolean {
    return student.grades.any { grade -> grade.type == GradeType.A}
}


fun getStudentAges(students: List<Student>): List<Int> {
    return students.asSequence().map { student -> student.age }.toList()
}

fun getStudentsWithMinimumAge(students: List<Student>, minAge: Int): List<Student> {
    return students.asSequence().filter{ student -> student.age >= minAge}.toList()
}


// gender == Gender.MALE
// or gender.name == "MALE"
fun countMaleStudents(students: List<Student>): Int {
    return students.asSequence().filter { student -> student.gender == Gender.MALE }.count()
}


// gender == Gender.FEMALE
// or gender.name == "FEMALE"
fun avgAgeOfFemaleStudent(students: List<Student>): Double {
    return students.asSequence().filter { student -> student.gender == Gender.FEMALE }.map { student -> student.age }.average()
}

fun getProductOfStudentAges(students: List<Student>): Int {
    return students.asSequence().map { student -> student.age }.reduce{acc, i -> i * acc }
}

// ignore F Grades
fun productOfStudentGrades(student: Student): Int {
    return student.grades.asSequence().map { grade -> grade.type.value }.reduce{acc, i -> i * acc}
}

// region BONUS

// use maxByOrNull on grades
fun getBestMathGradeFromStudent(student: Student): Grade? {
    TODO()
}

fun getSortedAges(students: List<Student>): List<Int> {
    TODO()
}

// endregion

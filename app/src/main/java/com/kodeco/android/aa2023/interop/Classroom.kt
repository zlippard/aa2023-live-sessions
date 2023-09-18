package com.kodeco.android.aa2023.interop

data class Classroom(
    val students: List<Person>,
) {
    companion object {
        const val TAG = "Classroom"
    }
}

fun someClassroomFunction(classroom: Classroom) {
    classroom.students.forEach { student ->
        println("${student.name} age ${student.age}")
    }
}

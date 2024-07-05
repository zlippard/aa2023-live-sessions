package com.kodeco.android.aa2023.repositories

import com.kodeco.android.aa2023.interop.Classroom
import com.kodeco.android.aa2023.interop.Person
import com.kodeco.android.aa2023.interop.School
import javax.inject.Inject

interface SchoolRepository {
    fun getSchool(value: Int): School
}

class SchoolRepositoryImpl @Inject constructor() : SchoolRepository {
    override fun getSchool(value: Int): School = School(
        listOf(
            Classroom(
                students = listOf(
                    Person(
                        "John",
                        12,
                    ),
                    Person(
                        "Jane",
                        12,
                    ),
                ),
            ),
            Classroom(
                students = listOf(
                    Person(
                        "Sam",
                        12,
                    ),
                    Person(
                        "Sally",
                        12,
                    ),
                ),
            ),
        ),
    )
}

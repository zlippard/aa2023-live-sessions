package com.kodeco.android.aa2023.ui.screens

import com.google.common.base.Verify.verify
import com.kodeco.android.aa2023.interop.School
import com.kodeco.android.aa2023.repositories.SchoolRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Test

class MainViewModelTest {
//    val fakeSchoolRepo = object : SchoolRepository {
//        var getSchoolInvokedCount = 0
//        override fun getSchool(): School {
//            getSchoolInvokedCount++
//            // return some School object
//        }
//    }

    @Test
    fun `mainViewModel getSchool returns proper school from repo`() {
        // Arrange
        val expectedSchool = mockk<School>()
        val mockRepo = mockk<SchoolRepository>()
//        val capturedValue = slot<Int>()
        val sut = MainViewModel(mockRepo)
        every { mockRepo.getSchool(any()) } returns expectedSchool

        // Act
        val result = sut.getSchool()

        // Assert
        assertEquals(expectedSchool, result)
//        verify(exactly = 1) { mockRepo.getSchool(1) }
//        assertEquals(1, capturedValue.captured)
    }
}

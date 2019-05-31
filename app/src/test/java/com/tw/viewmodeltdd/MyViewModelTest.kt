package com.tw.viewmodeltdd

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.clearAllMocks
import io.mockk.mockk
import io.mockk.verify
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

internal class MyViewModelTest {
    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    private val routerMock: Router = mockk(relaxed = true)
    private lateinit var sut: MyViewModel

    @Before
    fun init() {
        clearAllMocks()
        sut = MyViewModel(routerMock)
    }

    @Test
    fun `update the counter result text whenever count is called`() {
        count(1)
        var expectedCounter = 1
        assertEquals("Button is clicked $expectedCounter times", sut.resultText.value)

        count(3)
        expectedCounter = 4
        assertEquals("Button is clicked $expectedCounter times", sut.resultText.value)
    }

    @Test
    fun `navigate to result view when counter limit is reached`() {
        val clickedTimes = 11
        count(times = clickedTimes)
        verify {
            routerMock.navigateToResultActivity()
        }
    }

    private fun count(times: Int) {
        for (i in 1..times) {
            sut.count()
        }
    }
}
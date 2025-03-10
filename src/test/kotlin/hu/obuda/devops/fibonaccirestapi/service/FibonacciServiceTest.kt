package hu.obuda.devops.fibonaccirestapi.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FibonacciServiceTest {

    private val underTest = FibonacciService()
    @Test
    fun shouldReturn0WhenCall1() {
        // given

        // when
        val result: Int = underTest.fibonacci(1)
        // then
        Assertions.assertEquals(1, result)
    }
    @Test
    fun shouldReturn1WhenCall1() {
        // given

        // when
        val result: Int = underTest.fibonacci(2)
        // then
        Assertions.assertEquals(1, result)
    }

    @Test
    fun shouldReturn55WhenCall10() {
        // given

        // when
        val result: Int = underTest.fibonacci(2)
        // then
        Assertions.assertEquals(1, result)
    }

    @Test
    fun shouldThrowExceptionWhenCallFibonacciWithNegativeInput() {
        // given

        // when & then
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.fibonacci(-1)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.fibonacci(-1)
        }
    }

    @Test
    fun shouldThrowExceptionWhenCallFibonacciWith0Input() {
        // given

        // when & then
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.fibonacci(0)
        }

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            underTest.fibonacci(0)
        }
    }

    @Test
    fun `should throw BAD_REQUEST for n = 47`() {
        // Given
        val n = 47

        // When & Then
        val exception = assertThrows(ResponseStatusException::class.java) {
            underTest.fibonacci(n)
        }

        // Assert that the exception has the correct status code and message
        assertEquals(HttpStatus.BAD_REQUEST, exception.status)
        assertEquals("n > 46 is not allowed", exception.reason)
    }

    @Test
    fun `should throw BAD_REQUEST for n = 100`() {
        // Given
        val n = 100

        // When & Then
        val exception = assertThrows(ResponseStatusException::class.java) {
            underTest.fibonacci(n)
        }

        // Assert that the exception has the correct status code and message
        assertEquals(HttpStatus.BAD_REQUEST, exception.status)
        assertEquals("n > 46 is not allowed", exception.reason)
    }
    // TODO - Test with greater numbers and test edge cases
}
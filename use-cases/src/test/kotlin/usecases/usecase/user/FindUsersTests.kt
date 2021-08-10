package usecases.usecase.user

import domain.repository.IUserRepository
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class FindUsersTests {

    private val repository = mockk<IUserRepository>()
    private val usecase = FindUsers(repository)

    @Test
    fun success() {
        runBlocking {
            val expected = userModel
            every { runBlocking { repository.findById(id) } } returns user
            val actual = usecase.execute(id)
            assertEquals(actual, expected)
        }
        verify(exactly = 1) { runBlocking { repository.findById(any()) } }
    }

    @Test
    fun `No user`() {
        runBlocking {
            val expected = null
            every { runBlocking { repository.findById(any()) } } returns null
            val actual = usecase.execute(-1)
            assertEquals(actual, expected)
        }
    }
}

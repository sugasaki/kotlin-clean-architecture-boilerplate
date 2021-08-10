package repository.user

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNull

class UserRepositoryTests {

    private val repository = UserRepository()

    @Test
    fun `User tests`() {
        runBlocking {
            assertNull(repository.findById(-1))
            assertNotNull(repository.findById(1))
        }
    }
}

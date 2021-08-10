package repository.user

import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class UserRepositoryTests {

    @Test
    fun `User tests`() {
        runBlocking {

            val repository = UserRepository()

            val actual = repository.findById(1)
        }
    }
}

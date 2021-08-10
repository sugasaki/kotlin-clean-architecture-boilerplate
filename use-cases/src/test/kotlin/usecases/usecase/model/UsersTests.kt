package usecases.usecase.model

import org.assertj.core.api.Assertions
import usecases.usecase.user.user
import kotlin.test.Test

class UsersTests {

    @Test
    fun `toUserModel test`() {
        val expected = UserModel(id = user.id, firstName = user.firstName, lastName = user.lastName, email = user.email)
        val actual = user.toUserModel()
        Assertions.assertThat(actual).isEqualTo(expected)
    }
}

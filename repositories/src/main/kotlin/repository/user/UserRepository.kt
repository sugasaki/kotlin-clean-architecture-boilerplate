package repository.user

import domain.entity.user.Email
import domain.entity.user.User
import domain.repository.IUserRepository

class UserRepository : IUserRepository {
    override suspend fun findById(id: Long): User? {
        if (id < 0) return null

        // this mock
        return User(
            id = 2,
            firstName = "steve",
            lastName = "vai",
            email = Email("steve@pekehoge.com")
        )
    }
}

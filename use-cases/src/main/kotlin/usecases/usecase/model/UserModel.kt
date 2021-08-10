package usecases.usecase.model

import domain.entity.user.Email
import domain.entity.user.User

data class UserModel(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: Email
) {
    constructor(user: User) : this(id = user.id, firstName = user.firstName, lastName = user.lastName, email = user.email)
}

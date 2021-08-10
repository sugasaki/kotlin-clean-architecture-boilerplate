package domain.entity.user

import domain.entity.IEntity

data class User(
    override val id: Int = -1,
    val firstName: String,
    val lastName: String,
    val email: Email
) : IEntity

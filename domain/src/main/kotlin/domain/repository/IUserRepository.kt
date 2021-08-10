package domain.repository

import domain.entity.user.User

interface IUserRepository {
    suspend fun findById(id: Long): User?
}

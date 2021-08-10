package usecases.usecase.user

import domain.repository.IUserRepository
import usecases.usecase.model.UserModel

interface IFindUsers {
    suspend fun execute(id: Long): UserModel?
}

class FindUsers(
    private val repository: IUserRepository,
) : IFindUsers {

    override suspend fun execute(id: Long): UserModel? {
        return when (val result = repository.findById(id)) {
            null -> null
            else -> UserModel(result)
        }
    }
}

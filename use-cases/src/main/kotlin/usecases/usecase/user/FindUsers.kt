package usecases.usecase.user

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import domain.DomainMessage
import domain.repository.IUserRepository
import usecases.usecase.model.UserModel
import usecases.usecase.model.toUserModel

interface IFindUsers {
    suspend fun execute(id: Long): Result<UserModel, DomainMessage>
}

class FindUsers(
    private val repository: IUserRepository,
) : IFindUsers {

    override suspend fun execute(id: Long): Result<UserModel, DomainMessage> {
        return when (val result = repository.findById(id)) {
            is Ok -> Ok(result.value.toUserModel()) // Okの値はvalueで取得できる
            is Err -> result
        }
    }
}

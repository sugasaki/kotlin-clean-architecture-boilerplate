package interfaces.controller.user

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.get
import interfaces.controller.Response
import usecases.usecase.model.UserModel
import usecases.usecase.user.IFindUsers

class UsersController(
    private val findUsersUseCase: IFindUsers,
) {
    suspend fun findById(id: Long): Response<UserModel> {
        return when (val result = findUsersUseCase.execute(id)) {
            is Ok -> Response(200, result.value)
            else -> Response(400, errorMessage = "")
        }
    }
}

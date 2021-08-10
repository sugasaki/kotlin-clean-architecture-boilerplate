package interfaces.controller.user

import interfaces.controller.Response
import usecases.usecase.model.UserModel
import usecases.usecase.user.IFindUsers

class UsersController(
    private val findUsersUseCase: IFindUsers,
) {
    suspend fun findById(id: Long): Response<UserModel> {
        return when (val result = findUsersUseCase.execute(id)) {
            null -> Response(400, errorMessage = "")
            else -> Response(200, result)
        }
    }
}

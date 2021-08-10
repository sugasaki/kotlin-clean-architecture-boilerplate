package usecases.usecase.model

import com.mapk.annotations.KConverter
import com.mapk.kmapper.KMapper
import domain.entity.user.Email
import domain.entity.user.User

data class UserModel
@KConverter constructor(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: Email
)

fun User.toUserModel(): UserModel = KMapper(::UserModel).map(this)

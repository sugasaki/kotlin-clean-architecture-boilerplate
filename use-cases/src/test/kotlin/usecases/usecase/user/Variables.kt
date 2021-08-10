package usecases.usecase.user

import domain.entity.user.Email
import domain.entity.user.User
import usecases.usecase.model.UserModel

const val id: Long = 1
val email = Email("erik@erikschouten.com")
val user = User(id = id, firstName = "steve", lastName = "vai", email = email)
val userModel = UserModel(user)

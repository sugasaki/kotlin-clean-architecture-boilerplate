package infrastructure.config

import domain.repository.IUserRepository
import interfaces.controller.user.UsersController
import org.koin.dsl.module
import repository.user.UserRepository
import usecases.usecase.user.FindUsers
import usecases.usecase.user.IFindUsers

val AppModule = module {
    // Controllers
    single { UsersController(get()) }

    // Services
    single<IFindUsers> { FindUsers(get()) }

    // Repositories
    single<IUserRepository> { UserRepository() }
}

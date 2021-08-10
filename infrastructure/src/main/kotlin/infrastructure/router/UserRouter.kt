package infrastructure.router

import interfaces.controller.user.UsersController
import io.ktor.application.call
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Location
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import org.koin.ktor.ext.inject

@KtorExperimentalLocationsAPI
fun Route.configureUser() {
    val usersController by inject<UsersController>()

    get("/user") {
        call.respond(usersController.findById(1))
    }

    /**
     * userの取得
     * for exp. http://localhost:8080/user/{id}
     */
    get<Users> { param ->
        call.respond(usersController.findById(param.id))
    }
}

/**
 * Locations
 */
@KtorExperimentalLocationsAPI
@Location("/user/{id}")
data class Users(val id: Long)

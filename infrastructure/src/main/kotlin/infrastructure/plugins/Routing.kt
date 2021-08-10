package infrastructure.plugins

import infrastructure.router.configureUser
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing

@KtorExperimentalLocationsAPI
fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/news") {
            call.respondText("news!")
        }

        configureUser()
    }
}

package infrastructure

import infrastructure.config.AppModule
import infrastructure.plugins.configureRouting
import infrastructure.plugins.configureSerialization
import io.ktor.application.install
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.locations.Locations
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.netty.NettyApplicationEngine
import org.koin.ktor.ext.Koin

@KtorExperimentalLocationsAPI
fun main() {
    // creates a simple ktor server
    createServer().start(wait = true)
}

// BEGIN ktor_setup
@KtorExperimentalLocationsAPI
private fun createServer(): NettyApplicationEngine {

    return embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(Koin) {
            modules(AppModule)
        }

        install(Locations)

        configureSerialization()

        configureRouting()
    }
}
// END ktor_setup

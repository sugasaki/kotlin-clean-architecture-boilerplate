package infrastructure

import infrastructure.plugins.configureRouting
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.locations.KtorExperimentalLocationsAPI
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import kotlin.test.Test
import kotlin.test.assertEquals

@KtorExperimentalLocationsAPI
class UserTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
        handleRequest(HttpMethod.Get, "/user/1").apply {
            assertEquals(HttpStatusCode.OK, response.status())
        }
    }
    }
}

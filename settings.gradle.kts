pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(
    ":domain",
    ":infrastructure",
    ":repositories",
    ":use-cases"
)

enableFeaturePreview("VERSION_CATALOGS")
dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("coroutines", "1.5.1")
            version("ktor", "1.6.2")
            version("logback", "1.2.5")
            version("mockk", "1.12.0")
        }
    }
}

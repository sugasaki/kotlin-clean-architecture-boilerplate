
plugins {
    kotlin("jvm") version "1.5.21" apply false
}

allprojects {
    group = "com.sugasaki"
    version = "1.0-SNAPSHOT"
}

subprojects {

    apply(plugin = "kotlin")
    repositories {
        mavenCentral()
    }

    afterEvaluate {
        dependencies {
            "testImplementation"(kotlin("test"))
            "testImplementation"("org.jetbrains.kotlinx", "kotlinx-coroutines-core", libs.versions.coroutines.get())
            "testImplementation"("io.mockk", "mockk", libs.versions.mockk.get())
        }
    }

    // ktlint
    val ktlint by configurations.creating
    dependencies {
        ktlint("com.pinterest:ktlint:0.42.0") {
            attributes {
                attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.EXTERNAL))
            }
        }
        // ktlint(project(":custom-ktlint-ruleset")) // in case of custom ruleset
    }

    val outputDir = "${project.buildDir}/reports/ktlint/"
    val inputFiles = project.fileTree(mapOf("dir" to "src", "include" to "**/*.kt"))

    @Suppress("UNUSED_VARIABLE")
    val ktlintCheck by tasks.creating(JavaExec::class) {
        inputs.files(inputFiles)
        outputs.dir(outputDir)

        group = "ktlint"
        description = "Check Kotlin code style."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args = listOf("src/**/*.kt")
    }

    @Suppress("UNUSED_VARIABLE")
    val ktlintFormat by tasks.creating(JavaExec::class) {
        inputs.files(inputFiles)
        outputs.dir(outputDir)

        group = "ktlint"
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args = listOf("-F", "src/**/*.kt")
    }
}

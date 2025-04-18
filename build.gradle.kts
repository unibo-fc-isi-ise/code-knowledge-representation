import java.util.*

plugins {
    alias(libs.plugins.kotlin.jvm)
}

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(libs.tuprolog.ide)
    implementation(libs.tuprolog.repl)
}

listOf("gui", "repl").forEach {
    tasks.register<JavaExec>("runTuprolog${it.uppercase(Locale.getDefault())}", fun JavaExec.() {
        group = "tuprolog"
        mainClass.set("it.unibo.tuprolog.ui.$it.Main")
        sourceSets.main { classpath = runtimeClasspath }
        standardInput = System.`in`
    })
}

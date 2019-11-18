import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import dependencies.Dependencies

plugins {
    `java-library`
    kotlin
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(kotlin("stdlib-jdk8"))

    Dependencies.Coroutine.run {
        implementation(core)
        implementation(android)
    }

    implementation(Dependencies.Koin.core)
}

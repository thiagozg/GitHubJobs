import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import dependencies.Dependencies

plugins {
    id("androidLibraryPlugin")
    id("androidx.navigation.safeargs")
}

java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":libraries:core"))
    implementation(project(":features:main:domain"))
    implementation(project(":features:main:data"))

    Dependencies.run {
        implementation(appCompat)
        implementation(legacySupportV4)
        implementation(coreKtx)
        implementation(constraintLayout)
        implementation(materialDesign)
        implementation(lottie)
        implementation(glide)
    }

    Dependencies.Architecture.run {
        implementation(navigationKtx)
        implementation(navigationUiKtx)
        implementation(viewModel)
        implementation(viewModelKtx)
        implementation(liveDataCore)
    }

    Dependencies.Coroutine.run {
        implementation(core)
        implementation(android)
    }

    Dependencies.Koin.run {
        implementation(core)
        implementation(android)
        implementation(androidScope)
        implementation(androidViewModel)
    }

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests().forEach {
        androidTestImplementation(it)
    }
}
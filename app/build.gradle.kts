import dependencies.Dependencies

plugins {
    id("androidApplicationPlugin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":libraries:core"))
    implementation(project(":business:domain"))
    implementation(project(":business:data"))
    implementation(project(":features:jobsresults"))

    // FIXME: remove unused dependencies
    Dependencies.run {
        implementation(appCompat)
        implementation(legacySupportV4)
        implementation(coreKtx)
        implementation(constraintLayout)
        implementation(materialDesign)
        implementation(lottie)
        implementation(glide)
    }

    implementation(Dependencies.Coroutine.core)

    Dependencies.Architecture.run {
        implementation(navigationKtx)
        implementation(navigationUiKtx)
        implementation(viewModel)
        implementation(viewModelKtx)
        implementation(liveDataCore)
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

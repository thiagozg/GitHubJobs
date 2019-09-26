import dependencies.Dependencies

plugins {
    id("androidApplicationPlugin")
    id("androidx.navigation.safeargs")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":business:data"))

    Dependencies.AppModule.run {
        implementation(appCompat)
        implementation(legacySupportV4)
        implementation(coreKtx)
        implementation(constraintLayout)
        implementation(materialDesign)
        implementation(lottie)
        implementation(glide)
    }

    implementation(Dependencies.AppModule.Network.coroutineCore)

    Dependencies.AppModule.Architecture.run {
        implementation(navigationKtx)
        implementation(navigationUiKtx)
        implementation(viewModel)
        implementation(viewModelKtx)
        implementation(liveDataCore)
    }

    Dependencies.AppModule.Koin.run {
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

import dependencies.Dependencies

plugins {
    id("androidLibraryPlugin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":business:domain"))
    Dependencies.Network.run {
        implementation(okhttpLogging)
        implementation(retrofit)
        implementation(retrofitGson)
    }

    Dependencies.Coroutine.run {
        implementation(core)
        implementation(android)
    }

    implementation(Dependencies.Architecture.liveDataCore)

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests().forEach {
        androidTestImplementation(it)
    }
}
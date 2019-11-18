import dependencies.Dependencies

plugins {
    id("androidLibraryPlugin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":features:main:domain"))
    Dependencies.Network.run {
        implementation(okhttpLogging)
        implementation(retrofit)
        implementation(retrofitGson)
    }

    Dependencies.Coroutine.run {
        implementation(core)
        implementation(android)
    }

    Dependencies.Koin.run {
        implementation(core)
        implementation(android)
    }

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests().forEach {
        androidTestImplementation(it)
    }
}
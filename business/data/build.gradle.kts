import dependencies.Dependencies

plugins {
    id("androidLibraryPlugin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":business:domain"))
    Dependencies.AppModule.Network.run {
        implementation(okhttpLogging)
        implementation(retrofit)
        implementation(retrofitGson)
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        implementation(coroutineRetrofitAdapter)
    }

    implementation(Dependencies.AppModule.Architecture.liveDataCore)

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests().forEach {
        androidTestImplementation(it)
    }
}
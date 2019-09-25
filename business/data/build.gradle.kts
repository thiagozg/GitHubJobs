import dependencies.Dependencies

plugins {
    id("androidLibraryPlugin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    Dependencies.AppModule.Network.run {
        implementation(okhttpLogging)
        implementation(retrofit)
        implementation(retrofitGson)
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        implementation(coroutineRetrofitAdapter)
    }

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests().forEach {
        androidTestImplementation(it)
    }
}
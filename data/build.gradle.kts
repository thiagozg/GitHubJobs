plugins {
    id("androidLibraryPlugin")
}

//
//dependencies {
//    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
//    Dependencies.AppModule.Network.run {
//        implementation(okhttpLogging)
//        implementation(retrofit)
//        implementation(retrofitGson)
//        implementation(coroutineCore)
//        implementation(coroutineAndroid)
//        implementation(coroutineRetrofitAdapter)
//    }
//
//    Dependencies.AppModule.Koin.run {
//        implementation(core)
//        implementation(android)
//        implementation(androidScope)
//        implementation(androidViewModel)
//    }
//
//    testImplementation(Dependencies.UnitTests.jUnit)
//
//    Dependencies.UiTests().forEach {
//        androidTestImplementation(it)
//    }
//}
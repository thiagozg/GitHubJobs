import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    id("androidx.navigation.safeargs")
}

android {
    compileSdkVersion(Version.Android.compileSdkVersion)
    defaultConfig {
        Version.Android.run {
            applicationId = appId
            minSdkVersion(minSdk)
            targetSdkVersion(targetSdk)
            versionCode = code
            versionName = name
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    androidExtensions {
        configure(delegateClosureOf<AndroidExtensionsExtension> {
            isExperimental = true
        })
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    Dependencies.AppModule.run {
        implementation(appCompat)
        implementation(coreKtx)
        implementation(constraintLayout)
        implementation(materialDesign)
        implementation(lottie)
        implementation(legacySupportV4)
    }

    Dependencies.AppModule.Network.run {
        implementation(okhttpLogging)
        implementation(retrofit)
        implementation(retrofitGson)
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        implementation(coroutineRetrofitAdapter)
    }

    Dependencies.AppModule.Architecture.run {
        implementation(navigationKtx)
        implementation(navigationUiKtx)
        implementation(viewModel)
        implementation(viewModelKtx)
        implementation(liveDataCore)
    }

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests.run {
        androidTestImplementation(extJUnit)
        androidTestImplementation(espressoCore)
    }
}

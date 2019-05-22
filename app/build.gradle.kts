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
        isExperimental = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    Dependencies.AppModule.run {
        implementation(appCompat)
        implementation(coreKtx)
        implementation(constraintLayout)
        implementation(navigationFragmentKtx)
        implementation(navigationUiKtx)
        implementation(materialDesign)
        implementation(lottie)
        implementation(legacySupportV4)
    }

    testImplementation(Dependencies.UnitTests.jUnit)

    Dependencies.UiTests.run {
        androidTestImplementation(extJUnit)
        androidTestImplementation(espressoCore)
    }
}

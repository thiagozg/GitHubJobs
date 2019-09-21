import dependencies.Dependencies
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

plugins {
    id("androidApplicationPlugin")
    // not necessary anymore because of custom plugin
    // kotlin("android")
    // kotlin("android.extensions")
    id("androidx.navigation.safeargs")
}

android {
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
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
        implementation(legacySupportV4)
        implementation(coreKtx)
        implementation(constraintLayout)
        implementation(materialDesign)
        implementation(lottie)
        implementation(glide)
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

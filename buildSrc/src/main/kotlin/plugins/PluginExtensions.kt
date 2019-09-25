package plugins

import Version
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.delegateClosureOf
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

/*
 * Created by Thiago Zagui Giacomini on 21/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
fun Project.configureAndroid() {
    val android = extensions.getByName("android") as? BaseExtension
    android?.configureAndroid()

    val androidExtension = extensions.getByName("androidExtensions") as? AndroidExtensionsExtension
    androidExtension?.configure(delegateClosureOf<AndroidExtensionsExtension> {
        isExperimental = true
    })
}

fun BaseExtension.configureAndroid() {
    compileSdkVersion(Version.Android.compileSdkVersion)
    buildToolsVersion(Version.Android.buildToolsVersion)
    defaultConfig {
        Version.Android.run {
            minSdkVersion(minSdk)
            targetSdkVersion(targetSdk)
            versionCode = code
            versionName = name
        }
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

fun Project.configurePlugins(): Unit = plugins.run {
    apply("kotlin-android")
    apply("kotlin-android-extensions")
}
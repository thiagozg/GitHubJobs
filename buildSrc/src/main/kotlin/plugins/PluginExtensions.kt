package plugins

import Version
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.internal.AndroidExtensionsExtension

/*
 * Created by Thiago Zagui Giacomini on 21/09/2019.
 * See thiagozg on GitHub: https://github.com/thiagozg
 */
fun Project.configureAndroid() {
    val android = extensions.getByName("android") as? BaseAppModuleExtension
    android?.configureAndroid()

    val androidExtension = extensions.getByName("android") as? AndroidExtensionsExtension
    androidExtension?.isExperimental = true
}

fun BaseAppModuleExtension.configureAndroid() {
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

fun Project.configurePlugins(): Unit = plugins.run {
    apply("kotlin-android")
    apply("kotlin-android-extensions")
}
buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:${Version.gradleAndroid}")
        classpath("android.arch.navigation:navigation-safe-args-gradle-plugin:${Version.navigationSafeArgs}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        jcenter()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}

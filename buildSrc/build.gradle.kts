plugins {
    `kotlin-dsl`
}

repositories {
    jcenter()
    mavenCentral()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle:3.5.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
}

gradlePlugin {
    plugins {
        register("AndroidApplicationPlugin") {
            id = "androidApplicationPlugin"
            implementationClass = "plugins.AndroidApplicationPlugin"
        }
        register("AndroidLibraryPlugin") {
            id = "androidLibraryPlugin"
            implementationClass = "plugins.AndroidLibraryPlugin"
        }
    }
}
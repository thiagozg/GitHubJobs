import dependencies.Dependencies

plugins {
    id("androidApplicationPlugin")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":libraries:core"))
    implementation(project(":features:main:jobsresults"))

    Dependencies.Koin.run {
        implementation(core)
        implementation(android)
    }
}

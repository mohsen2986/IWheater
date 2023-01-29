import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id (BuildPlugins.kotlin)
    id (BuildPlugins.javaLibrary)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


dependencies {
    implementation(project(":domain"))

    implementation(DataDependencies.kotlinStdLib)
    implementation(DataDependencies.kodein)
    implementation(DataDependencies.kodein_android_x)
    implementation(DataDependencies.coroutine)
    implementation(DataDependencies.coroutineAndroid)
}
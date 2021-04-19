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
    implementation(DomainDependencies.kotlinStdLib)
    implementation(DomainDependencies.kodein)
    implementation(DomainDependencies.kodein_android_x)
    implementation(DataDependencies.coroutine)
    implementation(DataDependencies.coroutineAndroid)
    implementation(DataDependencies.coroutine)
    implementation(DataDependencies.coroutineAndroid)
}
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id (BuildPlugins.kotlin)
    id (BuildPlugins.javaLibrary)
}

val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


dependencies {
    implementation(project(":Data"))
    implementation(project(":domain"))

    implementation ("com.facebook.stetho:stetho:1.5.1")
    implementation ("com.facebook.stetho:stetho-okhttp3:1.5.1")

    implementation(RemoteDependencies.kotlinStdLib)
    implementation(RemoteDependencies.kodein)
    implementation(RemoteDependencies.kodein_android_x)
    implementation(RemoteDependencies.coroutine)
    implementation(RemoteDependencies.coroutineAndroid)
    implementation(RemoteDependencies.okhttp)
    implementation(RemoteDependencies.okhttpInterceptor)
    implementation(RemoteDependencies.retrofit)
    implementation(RemoteDependencies.retrofitConverter)


}
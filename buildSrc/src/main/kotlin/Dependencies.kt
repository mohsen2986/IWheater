const val kotlinVersion = "1.3.71"
const val coroutineVersion = "1.0.1"

object Config{
    const val applicationId = "com.iwheater"
    const val versionCode = 1
    const val versionName = "1.0"
}

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.6.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}


object AndroidSdk {
    const val min = 19
    const val compile = 29
    const val target = compile
    const val buildToolsVersion = "29.0.3"
}

object MobileUIDependencies{
    private object Versions {
        const val jetpack = "1.0.0-beta01"
        const val constraintLayout = "1.1.2"
        const val ktx = "1.1.0-alpha05"
        const val material = "1.2.1"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val materialDesign = "com.google.android.material:material:${Versions.material}"
}
object MobileUITestDependencies{
    const val AndroidJunitRunner = "androidx.test.runner.AndroidJUnitRunner"
}


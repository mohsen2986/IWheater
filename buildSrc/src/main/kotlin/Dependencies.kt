const val kotlinVersion = "1.7.20"
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
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

    // domain plugins
    const val kotlin = "kotlin"
    const val javaLibrary = "java-library"
    const val kotlinKapt = "kotlin-kapt"
}


object AndroidSdk {
    const val min = 21
    const val compile = 30
    const val target = compile
}

object MobileUIDependencies{
    private object Versions {
        const val jetpack = "1.4.1"
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

object DomainDependencies{
    private object Versions{
        const val kodein = "6.5.5"
        const val coroutine = "1.3.3"
    }
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
    const val kodein_android_x = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
}
object DataDependencies{
    private object Versions{
        const val kodein = "6.5.5"
        const val coroutine = "1.3.3"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
    const val kodein_android_x = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"
}


object RemoteDependencies{
    private object Versions{
        const val kodein = "6.5.5"
        const val coroutine = "1.3.3"
        const val okhttpVersion = "3.12.0"
        const val retrofitVersion = "2.6.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
    const val kodein_android_x = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val okhttp            = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val retrofit          = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
}

object PresentationDependencies{
    private object Versions{
        const val kodein = "6.5.5"
        const val coroutine = "1.3.3"
        const val okhttpVersion = "3.12.0"
        const val retrofitVersion = "2.4.0"
        const val lifecycle = "2.5.1"
        const val lifecycle2 = "2.2.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
    const val kodein_android_x = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val okhttp            = "com.squareup.okhttp3:okhttp:${Versions.okhttpVersion}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpVersion}"
    const val retrofit          = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"

    val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle2}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle2}"

}

object CacheDependencies{
    private object Versions{
        const val kodein = "6.5.5"
        const val coroutine = "1.3.3"
        const val lifecycle = "2.5.1"
        const val lifecycle2 = "2.2.0"
        const val room = "2.3.0-alpha03"
        const val androidXAppCompat = "1.1.0-alpha01"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion"
    const val kodein = "org.kodein.di:kodein-di-generic-jvm:${Versions.kodein}"
    const val kodein_android_x = "org.kodein.di:kodein-di-framework-android-x:${Versions.kodein}"
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutine}"
    const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutine}"

    const val roomRuntime       = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler      = "androidx.room:room-compiler:${Versions.room}"
    const val appCompat         = "androidx.appcompat:appcompat:${Versions.androidXAppCompat}"


    val viewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.lifecycle}"
    val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle2}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle2}"

}




plugins {
    id (BuildPlugins.androidLibrary)
    id (BuildPlugins.kotlinAndroid)
    id (BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion (30)

    defaultConfig {
        minSdkVersion (AndroidSdk.min)
        targetSdkVersion (AndroidSdk.target)
//        versionCode = 1
//        versionName = Config.versionName

        testInstrumentationRunner = MobileUITestDependencies.AndroidJunitRunner
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


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget =  JavaVersion.VERSION_1_8.toString()
    }
//    libraryVariants.all {
//        this.generateBuildConfig?.enabled = false
//    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":Data"))

    implementation(CacheDependencies.kotlinStdLib)
    implementation(CacheDependencies.kodein)
    implementation(CacheDependencies.kodein_android_x)
    implementation(CacheDependencies.coroutine)
    implementation(CacheDependencies.coroutineAndroid)
//    implementation(CacheDependencies.roomRuntime)
//    kapt(CacheDependencies.roomCompiler)
    annotationProcessor("androidx.room:room-compiler:2.4.3")
    implementation ("androidx.room:room-ktx:2.4.3")
    kapt("androidx.room:room-compiler:2.4.3")
    implementation(CacheDependencies.appCompat)

    implementation(CacheDependencies.viewModelKtx)
    implementation(CacheDependencies.lifecycleExt)
    kapt(CacheDependencies.lifecycleCompiler)

}

plugins {
    id (BuildPlugins.androidLibrary)
    id (BuildPlugins.kotlinAndroid)
    id (BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion (30)
    buildToolsVersion (AndroidSdk.buildToolsVersion)

    defaultConfig {
        minSdkVersion (AndroidSdk.min)
        targetSdkVersion (AndroidSdk.target)
        versionCode = Config.versionCode
        versionName = Config.versionName

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


//    compileOptions {
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8
//    }
//    kotlinOptions {
//        jvmTarget =  JavaVersion.VERSION_11.toString()
//    }
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
    implementation(CacheDependencies.roomRuntime)
    kapt(CacheDependencies.roomCompiler)
    implementation(CacheDependencies.appCompat)

    implementation(CacheDependencies.viewModelKtx)
    implementation(CacheDependencies.lifecycleExt)
    implementation(CacheDependencies.lifecycleKtx)
    kapt(CacheDependencies.lifecycleCompiler)

}
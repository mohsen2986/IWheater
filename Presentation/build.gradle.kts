
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
}

    dependencies {
        implementation(project(":domain"))

        implementation(PresentationDependencies.kotlinStdLib)
        implementation(PresentationDependencies.kodein)
        implementation(PresentationDependencies.kodein_android_x)
        implementation(PresentationDependencies.coroutine)
        implementation(PresentationDependencies.coroutineAndroid)
        implementation(PresentationDependencies.okhttp)
        implementation(PresentationDependencies.okhttpInterceptor)
        implementation(PresentationDependencies.retrofit)
        implementation(PresentationDependencies.retrofitConverter)

        implementation(PresentationDependencies.viewModel)
        implementation(PresentationDependencies.viewModelKtx)
        implementation(PresentationDependencies.lifecycleExt)
        kapt(PresentationDependencies.lifecycleCompiler)

}
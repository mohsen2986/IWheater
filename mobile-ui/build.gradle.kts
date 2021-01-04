plugins {
    id (BuildPlugins.androidApplication)
    id ("kotlin-android")
}

android {
    compileSdkVersion (30)
    buildToolsVersion ("30.0.2")

    defaultConfig {
        applicationId = Config.applicationId
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(MobileUIDependencies.kotlinStdLib)
    implementation(MobileUIDependencies.ktxCore)
    implementation(MobileUIDependencies.appCompat)
    implementation(MobileUIDependencies.constraintLayout)
    implementation(MobileUIDependencies.materialDesign)
}
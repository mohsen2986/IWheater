plugins {
    id (BuildPlugins.androidApplication)
    id (BuildPlugins.kotlinAndroid)
    id (BuildPlugins.kotlinKapt)
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdkVersion (33)

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

    buildFeatures.dataBinding = true
    buildFeatures.viewBinding = true

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
//        kotlinCompilerVersion = "1.1.0"
    }
}

dependencies {
    implementation(project(":Presentation"))
    implementation(project(":domain"))
    implementation(project(":Data"))
    implementation(project(":Remote"))
    implementation(project(":Cache"))

    implementation(MobileUIDependencies.kotlinStdLib)
    implementation(MobileUIDependencies.ktxCore)
    implementation(MobileUIDependencies.appCompat)
    implementation(MobileUIDependencies.constraintLayout)
    implementation(MobileUIDependencies.materialDesign)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    // KODEIN
    implementation ("org.kodein.di:kodein-di-generic-jvm:6.5.5")
    implementation ("org.kodein.di:kodein-di-framework-android-x:6.5.5")

    // navigation
    implementation ("androidx.navigation:navigation-fragment-ktx:2.2.1")
    implementation ("androidx.navigation:navigation-ui-ktx:2.2.1")

    // NETWORK MONITORING
    implementation ("com.facebook.stetho:stetho:1.5.1")
    implementation ("com.facebook.stetho:stetho-okhttp3:1.5.1")

    // Compose
    implementation ("androidx.compose.ui:ui:1.3.3")
    implementation ("androidx.compose.material:material:1.3.1")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.3")

}
plugins {
    id (BuildPlugins.androidApplication)
    id (BuildPlugins.kotlinAndroid)
    id (BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion (30)
    buildToolsVersion (AndroidSdk.buildToolsVersion)

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
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

}
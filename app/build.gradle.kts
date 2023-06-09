@file:Suppress("UnstableApiUsage","DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.androidKotlin)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.mecheka.composenews"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.mecheka.composenews"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {
    implementation(project(":features:general"))
    implementation(project(":features:business"))

    implementation(libs.coreKtx)
    implementation(libs.appCompat)
    implementation(libs.material)
    implementation(platform(libs.composeBom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.composeTool)

    implementation(libs.hiltAndroid)
    kapt(libs.hiltCompiler)
}

kapt {
    correctErrorTypes = true
}
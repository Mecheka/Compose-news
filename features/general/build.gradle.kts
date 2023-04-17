@file:Suppress("UnstableApiUsage","DSL_SCOPE_VIOLATION")

plugins {
    alias(libs.plugins.androidLib)
    alias(libs.plugins.androidKotlin)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.mecheka.features.general"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

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
    api(project(":core"))
    implementation(project(":data"))

    implementation(libs.coreKtx)
    implementation(libs.appCompat)
    implementation(libs.lifecycleCompose)

    implementation(platform(libs.composeBom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.composeTool)

    implementation(libs.hiltAndroid)
    implementation(libs.hiltCompose)
    kapt(libs.hiltCompiler)
}

kapt {
    correctErrorTypes = true
}
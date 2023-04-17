@file:Suppress("UnstableApiUsage","DSL_SCOPE_VIOLATION")

import java.util.Properties

plugins {
    alias(libs.plugins.androidLib)
    alias(libs.plugins.androidKotlin)
    alias(libs.plugins.hilt)
    kotlin("kapt")
}

android {
    namespace = "com.mecheka.data"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val properties = Properties()
        properties.load(project.rootProject.file("local.properties").inputStream())
        val apiKey = properties.getProperty("api_key")
        buildConfigField("String", "API_KEY", apiKey)
        buildConfigField("String", "BASE_URL", "\"https://newsapi.org\"")
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
}

dependencies {
    implementation(libs.hiltAndroid)
    kapt(libs.hiltCompiler)

    implementation(libs.bundles.retrofit)
}

kapt {
    correctErrorTypes = true
}
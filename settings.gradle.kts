@file:Suppress("UnstableApiUsage")

rootProject.name = "ComposeNews"
include(":app")


pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            version("kotlin", "1.8.10")
            version("gradle", "8.0.0")
            version("appcompat", "1.6.1")
            version("compose", "1.4.2")
            version("composeBom", "2023.03.00")
            version("composeNavigation", "2.5.3")
            version("coreKtx", "1.10.0")
            version("constraintlayout", "2.1.4")
            version("hilt", "2.44")
            version("material", "1.8.0")

            plugin("androidApplication", "com.android.application").versionRef("gradle")
            plugin("androidLib", "com.android.library").versionRef("gradle")
            plugin("androidKotlin", "org.jetbrains.kotlin.android").versionRef("kotlin")
            plugin("hilt", "com.google.dagger.hilt.android").versionRef("hilt")

            library("coreKtx", "androidx.core", "core-ktx").versionRef("coreKtx")
            library("appCompat", "androidx.appcompat", "appcompat").versionRef("appcompat")
            library("material", "com.google.android.material", "material").versionRef("material")
            library("constraintLayout", "androidx.constraintlayout", "constraintlayout").versionRef("constraintlayout")

            library("composeBom", "androidx.compose", "compose-bom").versionRef("composeBom")
            library("composeMaterial", "androidx.compose.material", "material").withoutVersion()
            library("composeFoundation", "androidx.compose.foundation", "foundation").withoutVersion()
            library("composeUi", "androidx.compose.ui", "ui").withoutVersion()
            library("composePreview", "androidx.compose.ui", "ui-tooling-preview").withoutVersion()
            library("composeTool", "androidx.compose.ui", "ui-tooling").withoutVersion()
            library("composeActivity", "androidx.activity", "activity-compose").version("1.6.1")
            library("composeNavigation", "androidx.navigation", "navigation-compose").versionRef("composeNavigation")

            bundle("compose", listOf("composeMaterial", "composeFoundation", "composeUi", "composePreview", "composeActivity", "composeNavigation"))

            library("hiltAndroid", "com.google.dagger", "hilt-android").versionRef("hilt")
            library("hiltCompiler", "com.google.dagger", "hilt-android-compiler").versionRef("hilt")

            library("retrofit", "com.squareup.retrofit2", "retrofit").version("2.9.0")
            library("moshi", "com.squareup.retrofit2", "converter-moshi").version("1.14.0")
        }
    }
}

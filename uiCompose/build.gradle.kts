plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotlinSerialization)
}

kotlin {

    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "UiCompose"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)
                implementation(compose.uiTooling)

                // koin DI
                implementation(libs.koin.android)
        }

        commonMain.dependencies {
            implementation(projects.domain)

            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)
            implementation(compose.components.uiToolingPreview)

            // Paging
            implementation(libs.paging.compose)

            // Navigation
            implementation(libs.navigation.compose)

            // MVVM
            implementation(libs.viewmodel.compose)

            // Coil3
            implementation(libs.coil.compose)
            implementation(libs.coil.network)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization)

            // DI
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            // Logger
            implementation(libs.kermit.logger)

        }
    }
}

android {
    namespace = "com.ibenabdallah.themoviedb"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        implementation(projects.domain)
        debugImplementation(libs.compose.ui.tooling)
        implementation(libs.kotlinx.coroutines.android)
    }
}



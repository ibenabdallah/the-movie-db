plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {

    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Domain"
            isStatic = true
        }
    }

    sourceSets {

        androidMain.dependencies {
            // koin DI
            implementation(libs.koin.android)
        }

        commonMain.dependencies {

            implementation(projects.data)
            api(projects.model)

            // Paging
            implementation(libs.paging.compose)

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
}



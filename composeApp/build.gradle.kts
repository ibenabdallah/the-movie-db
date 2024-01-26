import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.kotliniSerialization)
    alias(libs.plugins.buildKonfig)
}

kotlin {

    androidTarget()
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {

        androidMain {
            dependsOn(commonMain.get())

            dependencies {
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.androidx.activity.compose)

                // ktor network
                implementation(libs.ktor.client.okhttp)

                // koin DI
                implementation(libs.koin.android)
            }
        }

        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.materialIconsExtended)

            // Paging
            implementation(libs.paging.compose)

            // Navigation
            implementation(libs.precompose)

            // MVVM
            implementation(libs.moko.mvvm.compose)

            // Coil3
            implementation(libs.coil.compose)
            implementation(libs.coil.network)

            // Ktor network
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.serialization)
            implementation(libs.ktor.negotiation)

            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlin.serialization)

            // DI
            implementation(libs.koin.core)
            implementation(libs.koin.compose)

            // Logger
            implementation(libs.kermit.logger)

        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain.get())
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                // ktor network
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

android {
    namespace = "com.ibenabdallah.themoviedb"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")

    defaultConfig {
        applicationId = "com.ibenabdallah.themoviedb"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "0.1.0"
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
        debugImplementation(libs.compose.ui.tooling)
        implementation(libs.kotlinx.coroutines.android)
    }
}

buildkonfig {
    packageName = "com.ibenabdallah.themoviedb"

    defaultConfigs {
        buildConfigField(
            STRING,
            "API_KEY",
            gradleLocalProperties(rootDir).getProperty("api_key") ?: ""
        )
    }
}



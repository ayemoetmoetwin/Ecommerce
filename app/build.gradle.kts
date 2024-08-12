plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.firebase.gms)
}

android {
    namespace = "com.ammw.ecommercemobileapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.ammw.ecommercemobileapp"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.firebase.common.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.bundles.koin.bundle)
    implementation(libs.bundles.ktor.bundle)
    implementation(libs.glide.android)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.mmkv.android)
    implementation(libs.kotlinx.serialization)
    implementation(libs.nav.ui)
    implementation(libs.nav.fragment)
    implementation(libs.firebase.bom)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.firebase.database.ktx)
}
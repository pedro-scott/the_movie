plugins {
    id("my-application-plugin")
}

android {
    compileSdk = Dependencies.Version.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.github.pedroscott.movies_application"
        minSdk = Dependencies.Version.MIN_SDK_VERSION
        targetSdk = Dependencies.Version.TARGET_SDK_VERSION
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions.jvmTarget = "1.8"
    buildFeatures.viewBinding = true
}

dependencies {
    implementation("com.github.pedroscott:movies-feature:1.0.0")
}
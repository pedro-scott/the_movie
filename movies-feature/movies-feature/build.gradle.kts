plugins {
    id("my-library-plugin")
}

android {
    compileSdk = Dependencies.Version.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = Dependencies.Version.MIN_SDK_VERSION
        targetSdk = Dependencies.Version.TARGET_SDK_VERSION

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

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.pedroscott"
                artifactId = "movies-feature"
                version = "1.0.0"
            }
        }
    }
}
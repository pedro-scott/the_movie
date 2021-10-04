object Dependencies {
    object Version {
        // My Plugin
        const val BUILD_CONFIGURATION_PLUGIN_VERSION = "1.0.0"

        // Library Details
        const val COMPILE_SDK_VERSION = 31
        const val MIN_SDK_VERSION = 22
        const val TARGET_SDK_VERSION = 31

        // Classpath
        const val AGP_VERSION = "7.0.2"
        const val KOTLIN_VERSION = "1.5.30"
        const val SAFE_ARGS_GRADLE_PLUGIN_VERSION = "2.3.5"

        // Implementation
        const val CORE_VERSION = "1.6.0"
        const val APPCOMPAT_VERSION = "1.3.1"
        const val MATERIAL_VERSION = "1.4.0"
        const val CONSTRAINT_LAYOUT_VERSION = "2.1.0"
        const val LEGACY_SUPPORT_VERSION = "1.0.0"
        const val NAVIGATION_FRAGMENT_VERSION = "2.3.5"
        const val NAVIGATION_UI_VERSION = "2.3.5"
        const val PAGING_VERSION = "3.0.1"
        const val LIFECYCLE_VIEWMODEL_VERSION = "2.4.0-beta01"
        const val LIFECYCLE_LIVEDATA_VERSION = "2.4.0-beta01"
        const val ROOM_RUNTIME_VERSION = "2.3.0"
        const val ROOM_COMPILER_VERSION = "2.3.0"
        const val ROOM_KTX_VERSION = "2.3.0"
        const val JUNIT_VERSION = "4.13.2"
        const val JUNIT_EXT_VERSION = "1.1.3"
        const val ESPRESSO_VERSION = "3.4.0"
        const val RETROFIT_VERSION = "2.9.0"
        const val GSON_VERSION = "2.9.0"
        const val LOGGING_INTERCEPTOR_VERSION = "4.9.1"
        const val KOIN_VERSION = "3.1.2"
        const val LOTTIE_VERSION = "4.1.0"
        const val GLIDE_RUNTIME_VERSION = "4.12.0"
        const val GLIDE_COMPILER_VERSION = "4.12.0"
    }

    object Libs {
        // My Plugin
        const val BUILD_CONFIGURATION_PLUGIN_LIB = "com.pedro.gradle:build-configuration:${Version.BUILD_CONFIGURATION_PLUGIN_VERSION}"

        // Classpath
        const val AGP_LIB = "com.android.tools.build:gradle:${Version.AGP_VERSION}"
        const val KOTLIN_LIB = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.KOTLIN_VERSION}"
        const val SAFE_ARGS_GRADLE_PLUGIN_LIB = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.SAFE_ARGS_GRADLE_PLUGIN_VERSION}"

        // Implementation
        const val CORE_LIB = "androidx.core:core-ktx:${Version.CORE_VERSION}"
        const val APPCOMPAT_LIB = "androidx.appcompat:appcompat:${Version.APPCOMPAT_VERSION}"
        const val MATERIAL_LIB = "com.google.android.material:material:${Version.MATERIAL_VERSION}"
        const val CONSTRAINT_LAYOUT_LIB = "androidx.constraintlayout:constraintlayout:${Version.CONSTRAINT_LAYOUT_VERSION}"
        const val LEGACY_SUPPORT_LIB = "androidx.legacy:legacy-support-v4:${Version.LEGACY_SUPPORT_VERSION}"
        const val NAVIGATION_FRAGMENT_LIB = "androidx.navigation:navigation-fragment-ktx:${Version.NAVIGATION_FRAGMENT_VERSION}"
        const val NAVIGATION_UI_LIB = "androidx.navigation:navigation-ui-ktx:${Version.NAVIGATION_UI_VERSION}"
        const val PAGING_LIB = "androidx.paging:paging-runtime-ktx:${Version.PAGING_VERSION}"
        const val LIFECYCLE_VIEWMODEL_LIB = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.LIFECYCLE_VIEWMODEL_VERSION}"
        const val LIFECYCLE_LIVEDATA_LIB = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.LIFECYCLE_LIVEDATA_VERSION}"
        const val ROOM_RUNTIME_LIB = "androidx.room:room-runtime:${Version.ROOM_RUNTIME_VERSION}"
        const val ROOM_COMPILER_LIB = "androidx.room:room-compiler:${Version.ROOM_COMPILER_VERSION}"
        const val ROOM_KTX_LIB = "androidx.room:room-ktx:${Version.ROOM_KTX_VERSION}"
        const val JUNIT_LIB = "junit:junit:${Version.JUNIT_VERSION}"
        const val JUNIT_EXT_LIB = "androidx.test.ext:junit:${Version.JUNIT_EXT_VERSION}"
        const val ESPRESSO_LIB = "androidx.test.espresso:espresso-core:${Version.ESPRESSO_VERSION}"
        const val RETROFIT_LIB = "com.squareup.retrofit2:retrofit:${Version.RETROFIT_VERSION}"
        const val GSON_LIB = "com.squareup.retrofit2:converter-gson:${Version.GSON_VERSION}"
        const val LOGGING_INTERCEPTOR_LIB = "com.squareup.okhttp3:logging-interceptor:${Version.LOGGING_INTERCEPTOR_VERSION}"
        const val KOIN_LIB = "io.insert-koin:koin-android:${Version.KOIN_VERSION}"
        const val LOTTIE_LIB = "com.airbnb.android:lottie:${Version.LOTTIE_VERSION}"
        const val GLIDE_RUNTIME_LIB = "com.github.bumptech.glide:glide:${Version.GLIDE_RUNTIME_VERSION}"
        const val GLIDE_COMPILER_LIB = "com.github.bumptech.glide:compiler:${Version.GLIDE_COMPILER_VERSION}"
    }
}
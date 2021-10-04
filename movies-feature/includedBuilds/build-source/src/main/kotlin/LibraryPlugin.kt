import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class LibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyLibPlugins()
            applyLibDependencies()
        }
    }

    private fun Project.applyLibPlugins() {
        with(plugins) {
            apply("com.android.library")
            apply("kotlin-android")
            apply("kotlin-kapt")
            apply("maven-publish")
            apply("androidx.navigation.safeargs.kotlin")
        }
    }

    private fun Project.applyLibDependencies() {
        dependencies {

            // Kotlin
            "implementation"(Dependencies.Libs.CORE_LIB)

            // Android Core
            "implementation"(Dependencies.Libs.APPCOMPAT_LIB)
            "implementation"(Dependencies.Libs.MATERIAL_LIB)
            "implementation"(Dependencies.Libs.CONSTRAINT_LAYOUT_LIB)
            "implementation"(Dependencies.Libs.LEGACY_SUPPORT_LIB)

            // Android Jetpack - Navigation
            "implementation"(Dependencies.Libs.NAVIGATION_FRAGMENT_LIB)
            "implementation"(Dependencies.Libs.NAVIGATION_UI_LIB)

            // Android Jetpack - Paging
            "implementation"(Dependencies.Libs.PAGING_LIB)

            // Android Jetpack - Lifecycle
            "implementation"(Dependencies.Libs.LIFECYCLE_VIEWMODEL_LIB)
            "implementation"(Dependencies.Libs.LIFECYCLE_LIVEDATA_LIB)

            // Android Jetpack - Room
            "implementation"(Dependencies.Libs.ROOM_RUNTIME_LIB)
            "kapt"(Dependencies.Libs.ROOM_COMPILER_LIB)
            "implementation"(Dependencies.Libs.ROOM_KTX_LIB)

            // Tests
            "testImplementation"(Dependencies.Libs.JUNIT_LIB)
            "androidTestImplementation"(Dependencies.Libs.JUNIT_EXT_LIB)
            "androidTestImplementation"(Dependencies.Libs.ESPRESSO_LIB)

            // Http
            "implementation"(Dependencies.Libs.RETROFIT_LIB)
            "implementation"(Dependencies.Libs.GSON_LIB)
            "implementation"(Dependencies.Libs.LOGGING_INTERCEPTOR_LIB)

            // Koin
            "implementation"(Dependencies.Libs.KOIN_LIB)

            // Lottie Animation
            "implementation"(Dependencies.Libs.LOTTIE_LIB)

            // Glide
            "implementation"(Dependencies.Libs.GLIDE_RUNTIME_LIB)
            "kapt"(Dependencies.Libs.GLIDE_COMPILER_LIB)
        }
    }
}
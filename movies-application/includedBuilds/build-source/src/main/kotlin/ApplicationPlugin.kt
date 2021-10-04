import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class ApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            applyAppPlugins()
            applyAppDependencies()
        }
    }

    private fun Project.applyAppPlugins() {
        with(plugins) {
            apply("com.android.application")
            apply("kotlin-android")
        }
    }

    private fun Project.applyAppDependencies() {
        dependencies {

            // Kotlin
            "implementation"(Dependencies.Libs.CORE_LIB)

            // Android Core
            "implementation"(Dependencies.Libs.APPCOMPAT_LIB)
            "implementation"(Dependencies.Libs.MATERIAL_LIB)
            "implementation"(Dependencies.Libs.CONSTRAINT_LAYOUT_LIB)

            // Tests
            "testImplementation"(Dependencies.Libs.JUNIT_LIB)
            "androidTestImplementation"(Dependencies.Libs.JUNIT_EXT_LIB)
            "androidTestImplementation"(Dependencies.Libs.ESPRESSO_LIB)
        }
    }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

buildscript {
    dependencies {
        // Configura la versión de Hilt
        val hiltVersion by extra("2.52")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }

    subprojects.forEach { project ->
        logger.quiet("Updating settings for project ${project}")
        project.tasks.withType<JavaCompile> {
            options.compilerArgs.addAll(listOf("-Xlint:deprecation"))
        }
    }
}

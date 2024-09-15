// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    id("org.sonarqube") version "4.4.1.3373"
}

sonar {
    properties {
        property("sonar.projectKey", "alejandro-developer_solutions")
        property("sonar.organization", "alejandro-developer")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}

buildscript {
    dependencies {
        // Configura la versión de Hilt
        val hiltVersion by extra("2.52")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }

    //To see errors in detail
    subprojects.forEach { project ->
        logger.quiet("Updating settings for project ${project}")
        project.tasks.withType<JavaCompile> {
            options.compilerArgs.addAll(listOf("-Xlint:deprecation"))
        }
    }
}



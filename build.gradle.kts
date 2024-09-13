// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //noinspection GradleDependency
    id("com.google.dagger.hilt.android") version "2.46.1" apply false
}

subprojects.forEach { project ->
    logger.quiet("Updating settings for project ${project}")
    project.tasks.withType<JavaCompile> {
        options.compilerArgs.addAll(listOf("-Xlint:deprecation"))
    }
}
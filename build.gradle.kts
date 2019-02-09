import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    application
    jacoco
    kotlin("jvm") version "1.2.51"
}

group = "com.marcdenning"
version = "1.0.0-RC2"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    compile("com.github.ajalt", "clikt", "1.5.0")
    testCompile("com.nhaarman.mockitokotlin2", "mockito-kotlin", "2.0.0")
    testCompile("com.natpryce", "hamkrest", "1.6.0.0")
    testCompile("org.junit.jupiter", "junit-jupiter-api", "5.3.1")
    testCompile("org.junit.jupiter", "junit-jupiter-params", "5.3.1")
    testRuntime("org.junit.jupiter", "junit-jupiter-engine", "5.3.1")
}

jacoco {
    toolVersion = "0.8.3"
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

configure<ApplicationPluginConvention> {
    applicationName = "b64"
    mainClassName = "com.marcdenning.base64.Base64CliKt"
    applicationDefaultJvmArgs = listOf("-Dapplication.version=$version")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

tasks.withType<JacocoReport> {
    reports.html.isEnabled = true
    reports.xml.isEnabled = true

    sourceDirectories.plus(files("src/main/kotlin"))

    // After evaluate hook necessary to override default class directories and apply exclude rule
    afterEvaluate {
        classDirectories.plus(files(fileTree("build/classes/kotlin/main") {
            exclude("**/Base64*.*")
        }))
    }
}

tasks[JavaBasePlugin.CHECK_TASK_NAME].finalizedBy("jacocoTestReport")

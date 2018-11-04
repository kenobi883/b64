import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    application
    kotlin("jvm") version "1.2.51"
}

group = "com.marcdenning"
version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib-jdk8"))
    implementation("com.github.ajalt", "clikt", "1.5.0")
    testImplementation("com.nhaarman.mockitokotlin2", "mockito-kotlin", "2.0.0")
    testCompile("com.natpryce", "hamkrest", "1.6.0.0")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.3.1")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

configure<ApplicationPluginConvention> {
    applicationName = "b64"
    mainClassName = "com.marcdenning.base64.Base64CliKt"
    applicationDefaultJvmArgs = listOf("-Dapplication.version=${version}")
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

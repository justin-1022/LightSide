/*
 * This file was [INITIALLY!] generated by the Gradle 'init' task.
 */

import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `maven-publish`
    application
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

repositories {
    flatDir {
        dirs("libs")
    }
    flatDir() {
        dirs("plugins")
    }
    mavenCentral()
}

application {
    mainClass.set("edu.cmu.side.Workbench")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://raw.github.com/Deses/RiverLayout/mvn-repo/")
    }
}

dependencies {
    implementation("com.thoughtworks.xstream:xstream:1.4.19")
    implementation("com.thoughtworks.xstream:xstream-hibernate:1.4.19")
    implementation("edu.stanford.nlp:stanford-corenlp:3.9.2")
    implementation("edu.stanford.nlp:stanford-parser:3.9.2")
    implementation(":yeritools-min-1.0")
    implementation(":genesis")
    implementation("junit:junit:4.13.2")
    implementation("se.datadosen.riverlayout:riverlayout:1.1")
    implementation("nz.ac.waikato.cms.weka:weka-dev:3.9.6")
    implementation("nz.ac.waikato.cms.weka:bayesianLogisticRegression:1.0.5")
    implementation("nz.ac.waikato.cms.weka:LibSVM:1.0.10")
    implementation("nz.ac.waikato.cms.weka:LibLINEAR:1.9.7")
    implementation("nz.ac.waikato.cms.weka:chiSquaredAttributeEval:1.0.4")
    implementation("com.oracle.database.xml:xmlparserv2:21.5.0.0")
    implementation("org.apache.commons:commons-math3:3.6.1")
    implementation("org.simpleframework:simple-http:6.0.1")
    implementation("org.simpleframework:simple:5.1.6")
    implementation("org.simpleframework:simple-transport:6.0.1")
    implementation(kotlin("stdlib-jdk8"))
}

group = "edu.cmu.side"
version = "1.0-SNAPSHOT"
description = "LightSide"
java.sourceCompatibility = JavaVersion.VERSION_1_8

val testsJar by tasks.registering(Jar::class) {
    archiveClassifier.set("tests")
    from(sourceSets["test"].output)
}

publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
        artifact(testsJar)
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "edu.cmu.side.Workbench"
    }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
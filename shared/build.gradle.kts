import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
//    kotlin("multiplatform")
    id("com.codingfeline.buildkonfig") version "0.15.2"
    id("de.jensklingenberg.ktorfit") version "2.2.0"
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
}
buildscript{
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
        classpath(libs.buildkonfig.gradle.plugin.v0152)
    }

}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_13)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {

            implementation(libs.koin.core)
            implementation(libs.ktorfit.lib)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

}

android {
    namespace = "com.solbao.animo"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_13
        targetCompatibility = JavaVersion.VERSION_13
    }
    buildFeatures {
        buildConfig = true
    }

}
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(16)
    }
}

buildkonfig {
    packageName = "com.solbao.animo"
    objectName = "AppKonfig"
    exposeObjectWithName = "AppKonfig"

    defaultConfigs {

        buildConfigField(STRING, "BASE_PATH", "\"${project.property("basePath")}\"")
    }
    defaultConfigs("dev") {
        buildConfigField(STRING, "BASE_PATH", "\"${project.property("basePath")}\"")
    }
    targetConfigs {
        create("android") {
            buildConfigField(STRING, "BASE_PATH", "\"${project.property("basePath")}\"")

        }
        create("ios") {
            buildConfigField(STRING, "BASE_PATH", "\"${project.property("basePath")}\"")
        }
    }
    targetConfigs("dev") {
        create("ios") {
            buildConfigField(STRING, "BASE_PATH", "\"${project.property("basePath")}\"")
        }
    }
}
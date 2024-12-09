plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).version("2.1.0").apply(false)
    alias(libs.plugins.compose.compiler) apply false


    id("com.google.devtools.ksp") version "2.1.0-1.0.29"

}



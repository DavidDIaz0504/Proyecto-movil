plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "david.alejandro.projectecomm"
    compileSdk = 34

    defaultConfig {
        applicationId = "david.alejandro.projectecomm"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    //implementacion para hacer el slider de imagenes
    implementation ("com.github.denzcoskun:ImageSlideshow:0.1.2")
    //implementacion de picasso
    implementation ("com.squareup.picasso:picasso:2.8")


}
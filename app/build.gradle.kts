plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.ktckdidongnhom16"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ktckdidongnhom16"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("commons-io:commons-io:2.11.0")
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.microsoft.signalr:signalr:6.0.1")
    implementation("de.hdodenhof:circleimageview:3.1.0")
    implementation ("io.reactivex.rxjava3:rxjava:3.1.5")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
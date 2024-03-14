plugins {
    kotlin("kapt")
}
apply {
    from("$rootDir/settings/settings-module.gradle")
}

dependencies {

    "implementation"(project(Modules.settingsData))

    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))

    "implementation"(DaggerHilt.hiltAndroid)
    "kapt"(DaggerHilt.hiltCompiler)
    "implementation"(Coroutine.coroutines)

    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)
}
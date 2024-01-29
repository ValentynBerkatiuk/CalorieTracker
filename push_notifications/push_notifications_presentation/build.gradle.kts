plugins {
    kotlin("kapt")
}
apply {
    from("$rootDir/push_notifications/push-notifications.gradle")
}

dependencies {

    "implementation"(DaggerHilt.hiltAndroid)
    "implementation"(project(Modules.pushNotificationsData))
    "kapt"(DaggerHilt.hiltCompiler)
    "implementation"(Coroutine.coroutines)

    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)
}
plugins {
    kotlin("kapt")
}
apply {
    from("$rootDir/push_notifications/push-notifications.gradle")
}

dependencies {

    "implementation"(project(Modules.pushNotificationsData))

    "implementation"(DaggerHilt.hiltAndroid)
    "kapt"(DaggerHilt.hiltCompiler)
    "implementation"(Coroutine.coroutines)

    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
    "implementation"(Retrofit.moshiConverter)
}
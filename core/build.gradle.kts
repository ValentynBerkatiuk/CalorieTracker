apply {
    from("$rootDir/base-module.gradle")
}

dependencies {
    "implementation" (DataStore.dataStore)
    "implementation" (Coroutine.coroutines)
    "implementation" (Coroutine.coroutinesAndroid)

}
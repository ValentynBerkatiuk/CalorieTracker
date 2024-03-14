apply {
    from("$rootDir/settings/settings-module.gradle")
}

dependencies {
    "implementation"(project(Modules.settingsDomain))
    "implementation"(Coroutine.coroutines)
    "implementation"(AndroidX.viewmodelKtx)
}
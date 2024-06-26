apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.trackerDomain))
    "implementation"(Google.materialIcons)
    "implementation"(Coil.coilCompose)

    "implementation"(platform(Firebase.firebaseBom))
    "implementation"(Firebase.firebaseMessaging)
    "implementation"(Firebase.firebaseAnalytics)

}
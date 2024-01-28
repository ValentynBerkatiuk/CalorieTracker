apply {
    from("$rootDir/compose-module.gradle")
}

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(project(Modules.coreUi))
    "implementation"(project(Modules.trackerDomain))

    "implementation"(Coil.coilCompose)

    "implementation"(platform("com.google.firebase:firebase-bom:32.7.1"))
    "implementation"("com.google.firebase:firebase-messaging")
    "implementation"("com.google.firebase:firebase-analytics")

}
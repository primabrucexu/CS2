plugins {
    kotlin("jvm") version "2.0.0"
}

group = "cn.pbx.cs2"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
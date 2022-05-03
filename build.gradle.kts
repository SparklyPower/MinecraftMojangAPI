plugins {
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.serialization") version "1.6.21"
    `maven-publish`
}

group = "net.perfectdreams.minecraftmojangapi"
version = "0.0.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    api("org.jetbrains.kotlinx:kotlinx-serialization-core:1.3.2")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    api("io.ktor:ktor-client-core:2.0.0")
    implementation("com.github.ben-manes.caffeine:caffeine:3.0.6")
}

publishing {
    repositories {
        maven {
            name = "PerfectDreams"
            url = uri("https://repo.perfectdreams.net/")

            credentials {
                username = System.getProperty("USERNAME") ?: System.getenv("USERNAME")
                password = System.getProperty("PASSWORD") ?: System.getenv("PASSWORD")
            }
        }
    }

    publications {
        register("PerfectDreams", MavenPublication::class.java) {
            from(components["java"])
        }
    }
}
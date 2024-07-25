plugins {
    java
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "com.distribuida"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2023.0.0"

dependencies {

    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // PostgreSQL
    runtimeOnly("org.postgresql:postgresql")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")


    //----------------------------
    // Spring Boot Starter (reemplaza quarkus-arc y proporciona el contenedor IoC)
    implementation ("org.springframework.boot:spring-boot-starter")

    // REST API (reemplaza quarkus-resteasy-reactive)
    // implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // JSON (reemplaza quarkus-resteasy-reactive-jackson)
    implementation ("org.springframework.boot:spring-boot-starter-json")

    // JPA (reemplaza quarkus-hibernate-orm-panache)
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")

    // Service Discovery con Consul
    //implementation ("org.springframework.cloud:spring-cloud-starter-consul-discovery")

    // Actuator para health checks (reemplaza quarkus-smallrye-health)
    implementation ("org.springframework.boot:spring-boot-starter-actuator")

    //Spring Cloud Gateway
    implementation ("org.springframework.cloud:spring-cloud-starter-gateway")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

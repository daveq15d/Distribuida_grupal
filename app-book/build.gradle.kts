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
    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Spring Boot DevTools para desarrollo
    developmentOnly("org.springframework.boot:spring-boot-devtools")

    // PostgreSQL JDBC Driver (puede ser opcional si solo usas R2DBC)
    runtimeOnly("org.postgresql:postgresql")

    // Spring Data R2DBC para base de datos reactiva
    implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
    implementation("io.r2dbc:r2dbc-postgresql:0.8.13.RELEASE")

    // Starter WebFlux para aplicaciones reactivas
    implementation("org.springframework.boot:spring-boot-starter-webflux")

    // JSON soporte
    implementation("org.springframework.boot:spring-boot-starter-json")

    // Actuator para health checks
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    // Spring Cloud Gateway para el gateway
    implementation("org.springframework.cloud:spring-cloud-starter-gateway")

<<<<<<< HEAD
    // Spring Cloud OpenFeign para clientes REST declarativos
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")

    // JasperReports para reportes
    implementation("net.sf.jasperreports:jasperreports:7.0.0")
=======

    // Consul
    implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
    implementation("com.github.ben-manes.caffeine:caffeine:3.0.5")

    //Spring Boot Admin Server y Client
    implementation("de.codecentric:spring-boot-admin-starter-client:3.0.0")
    implementation("de.codecentric:spring-boot-admin-starter-server:3.0.0")
>>>>>>> main

    // Dependencias de test
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}


dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

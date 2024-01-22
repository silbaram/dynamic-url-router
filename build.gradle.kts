import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.2"
	id("io.spring.dependency-management") version "1.1.4"

	kotlin("jvm") version "1.9.22"
	kotlin("plugin.spring") version "1.9.22"
	kotlin("plugin.jpa") version "1.9.22"
}

group = "com.github.silbaram"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
}

dependencies {
	//
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-webflux")

	//Jackson 라이브러리의 Kotlin 모듈입니다. 이 모듈은 Kotlin 클래스를 Jackson이 사용하는 방식에 맞게 직렬화 및 역직렬화 할 수 있도록 합니다.
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	//Reactor의 Kotlin 확장 모듈입니다. 이 모듈은 Reactor의 Kotlin 확장 함수를 제공합니다.
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	//Kotlin의 리플렉션 라이브러리입니다. 이 라이브러리는 Kotlin의 리플렉션 API를 제공합니다.
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	//Kotlin 코루틴과 Project Reactor를 통합하는 라이브러리입니다. 이 라이브러리를 사용하면, 코루틴을 사용하여 비동기 작업을 쉽게 처리하고, 그 결과를 Project Reactor의 Mono나 Flux와 같은 리액티브 타입으로 변환할 수 있습니다.
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	runtimeOnly("com.h2database:h2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

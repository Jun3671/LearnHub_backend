# LearnHub Backend

LearnHub 백엔드 API 서버 프로젝트입니다.

## 프로젝트 개요

LearnHub는 학습 관리 플랫폼의 백엔드 서비스로, Spring Boot 기반의 RESTful API를 제공합니다.

### 주요 기술 스택

- **Java**: 17
- **Spring Boot**: 4.0.0
- **Spring Security**: 인증 및 권한 관리
- **Spring Data JPA**: 데이터베이스 ORM
- **Spring Web MVC**: RESTful API 개발
- **PostgreSQL**: 관계형 데이터베이스
- **Lombok**: 보일러플레이트 코드 감소
- **Gradle**: 빌드 및 의존성 관리

## 프로젝트 구조

```
LearnHub_backend/
└── learnhub-project/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── org/example/learnhubproject/
    │   │   │       └── LearnhubProjectApplication.java
    │   │   └── resources/
    │   │       └── application.properties
    │   └── test/
    │       └── java/
    │           └── org/example/learnhubproject/
    ├── build.gradle
    ├── settings.gradle
    └── gradlew
```

## 필수 요구사항

- **Java Development Kit (JDK)**: 17 이상
- **PostgreSQL**: 최신 버전
- **Gradle**: 프로젝트에 포함된 Gradle Wrapper 사용

## 설치 방법

### 1. 저장소 클론

```bash
git clone <repository-url>
cd LearnHub_backend/learnhub-project
```

### 2. PostgreSQL 데이터베이스 설정

PostgreSQL 데이터베이스를 생성하고, `src/main/resources/application.properties` 파일에 데이터베이스 연결 정보를 추가합니다:

```properties
spring.application.name=learnhub-project

# Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/learnhub
spring.datasource.username=your_username
spring.datasource.password=your_password

# JPA Configuration
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

### 3. 프로젝트 빌드

```bash
# Linux/Mac
./gradlew build

# Windows
gradlew.bat build
```

### 4. 애플리케이션 실행

```bash
# Linux/Mac
./gradlew bootRun

# Windows
gradlew.bat bootRun
```

서버는 기본적으로 `http://localhost:8080`에서 실행됩니다.

## 사용 예제

### 애플리케이션 실행

```bash
cd learnhub-project
./gradlew bootRun
```

### 테스트 실행

```bash
./gradlew test
```

### JAR 파일 생성

```bash
./gradlew bootJar
```

생성된 JAR 파일은 `build/libs/` 디렉토리에 위치합니다:

```bash
java -jar build/libs/learnhub-project-0.0.1-SNAPSHOT.jar
```

## 개발 환경 설정

### IDE 설정

#### IntelliJ IDEA
1. `File` > `Open` 선택
2. `learnhub-project` 디렉토리 선택
3. Gradle 프로젝트로 자동 인식 및 import

#### Eclipse/STS
1. `File` > `Import` > `Gradle` > `Existing Gradle Project`
2. `learnhub-project` 디렉토리 선택

### Lombok 플러그인 설치
- **IntelliJ IDEA**: Lombok 플러그인 설치 및 Annotation Processing 활성화
- **Eclipse/STS**: Lombok jar 파일 다운로드 및 설치

## API 문서

서버 실행 후 다음 URL에서 API 문서를 확인할 수 있습니다:
- Swagger UI: `http://localhost:8080/swagger-ui.html` (구현 예정)
- API Docs: `http://localhost:8080/api-docs` (구현 예정)

## 환경 변수

다음 환경 변수를 설정할 수 있습니다:

| 변수명 | 설명 | 기본값 |
|--------|------|--------|
| `SPRING_PROFILES_ACTIVE` | 활성화할 프로파일 | `default` |
| `SERVER_PORT` | 서버 포트 | `8080` |
| `DB_URL` | 데이터베이스 URL | `jdbc:postgresql://localhost:5432/learnhub` |
| `DB_USERNAME` | 데이터베이스 사용자명 | - |
| `DB_PASSWORD` | 데이터베이스 비밀번호 | - |

## 트러블슈팅

### 데이터베이스 연결 오류
- PostgreSQL 서비스가 실행 중인지 확인
- `application.properties`의 데이터베이스 연결 정보 확인
- 데이터베이스가 생성되어 있는지 확인

### 빌드 오류
- Java 17이 설치되어 있는지 확인: `java -version`
- Gradle 캐시 정리: `./gradlew clean`

### 포트 충돌
- 8080 포트가 이미 사용 중인 경우:
  ```properties
  server.port=8081
  ```

## 라이선스

이 프로젝트는 학습 목적으로 제작되었습니다.

## 기여

프로젝트에 기여하고 싶으시다면 Pull Request를 보내주세요.

## 연락처

문의사항이 있으시면 이슈를 등록해주세요.

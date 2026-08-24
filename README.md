# Milfoil Pattern Middle

Spring Boot MVC starter with Thymeleaf, GitHub OAuth2 login, H2, JPA, and a repository-backed `UserProfile`.

## Run locally

Create an OAuth app in GitHub with callback URL `http://localhost:8080/login/oauth2/code/github`, then run:

```sh
export GITHUB_CLIENT_ID=your-client-id
export GITHUB_CLIENT_SECRET=your-client-secret
mvn spring-boot:run
```

Open http://localhost:8080. The H2 database is in-memory for local development.
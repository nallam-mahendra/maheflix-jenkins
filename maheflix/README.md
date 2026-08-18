# 🎬 Maheflix

A complete, production-style **movie streaming browser web application** built with **Java 21**, **Spring Boot**, **Thymeleaf**, and **Maven**, inspired by the Netflix UI — featuring a hero banner, horizontally scrolling movie rows, a search page, and a movie detail page. CI is handled via a **Jenkins** pipeline.

> Demo/portfolio project only. Not affiliated with or endorsed by Netflix. All movie titles, posters, and descriptions are fictional placeholders.

---

## ✨ Features

- Netflix-style dark UI with a hero banner and "More Info" / "Play" buttons
- Multiple horizontally scrolling movie categories (Trending, New Releases, Originals, etc.)
- Search page with live query filtering by title/genre
- Individual movie detail pages
- Fully server-rendered with Thymeleaf — no frontend build step required
- Responsive card hover effects and smooth scaling animations

---

## 🛠 Tech Stack

| Layer         | Technology              |
|---------------|--------------------------|
| Language      | Java 21                  |
| Build Tool    | Maven 3.8+               |
| Framework     | Spring Boot 3.3 (Spring MVC) |
| Templating    | Thymeleaf                |
| CI/CD         | Jenkins (Declarative Pipeline) |
| Packaging     | Executable JAR           |

---

## 📁 Project Structure

```
wedding-invitation/            (root)
├── src/
│   └── main/
│       ├── java/com/maheflix/app/
│       │   ├── MaheflixApplication.java
│       │   ├── controller/HomeController.java
│       │   ├── model/Movie.java
│       │   └── service/MovieService.java
│       └── resources/
│           ├── application.properties
│           ├── static/css/style.css
│           └── templates/
│               ├── index.html
│               ├── search.html
│               └── detail.html
├── .gitignore
├── Jenkinsfile
├── README.md
└── pom.xml
```

---

## 🚀 Getting Started Locally

### Prerequisites
- Java 21 (JDK)
- Maven 3.8+

### Run
```bash
mvn clean install
mvn spring-boot:run
```

Then open **http://localhost:8080** in your browser.

### Build a JAR
```bash
mvn clean package
java -jar target/maheflix-webapp.jar
```

---

## 🔧 Jenkins CI/CD Pipeline

The included `Jenkinsfile` defines a declarative pipeline with the following stages:

1. **Checkout** — pulls source from SCM
2. **Build** — compiles the project with Maven
3. **Test** — runs unit tests and publishes JUnit results
4. **Package** — builds the executable Spring Boot JAR
5. **Archive Artifact** — archives the JAR as a Jenkins build artifact

### Jenkins Setup Requirements

In **Manage Jenkins → Tools**, configure the following named tools (or rename to match your Jenkins setup):

| Tool Name    | Type  | Version |
|--------------|-------|---------|
| `JDK-21`     | JDK   | Java 21 |
| `Maven-3.8`  | Maven | 3.8.x   |

Jenkins version used/tested: **2.568**

No Docker or Kubernetes is required — the pipeline builds and archives a plain runnable JAR that can be deployed with `java -jar` on any server with Java 21 installed.

---

## 🎨 Customizing Movies

All movie data lives in `MovieService.java` as an in-memory catalog. Poster and banner images are generated dynamically via placeholder image URLs (no external API key required), so the app runs immediately with no extra setup. To use real movie posters, swap the `posterUrl` / `bannerUrl` fields for your own licensed image URLs or hook up a movie database API of your choice.

---

## 📄 License

This is a personal/portfolio demo project. Use and modify freely for learning purposes.

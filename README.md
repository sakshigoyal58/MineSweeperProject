# MineSweeper Project

## Assumptions

- **Grid Size:** Accepted grid size ranges from 1x1 to 26x26.
- **Mines:** Minimum of 1 mine, maximum of 35% of the total number of squares in the grid.

## Installation

### Prerequisites

- **JDK**: JDK 8 or higher.
- **Maven**: For dependency management and building the project.
- **JUnit**: Included as a dependency in the Maven project.

### Setting Up on Windows

1. **Install JDK:**
   - Download from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html) or [AdoptOpenJDK](https://adoptium.net/).
   - Follow the installation prompts and set `JAVA_HOME`.

2. **Install Maven:**
   - Download from [Maven](https://maven.apache.org/download.cgi).
   - Set up `MAVEN_HOME` and update the `Path` variable.

3. **Verify Installation:**
   ```bash
   java -version
   mvn -version

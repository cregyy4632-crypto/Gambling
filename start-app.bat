@echo off
echo Setting up Java 17 environment...
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
set "PATH=C:\Program Files\Java\jdk-17\bin;%PATH%"

echo Verifying Java version...
java -version
echo.

echo Starting Blackjack Spring Boot Application...
echo.
echo The application will be available at: http://localhost:8080
echo Press Ctrl+C to stop the application
echo.

call .\mvnw.cmd spring-boot:run

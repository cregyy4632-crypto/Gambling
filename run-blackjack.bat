@echo off
title Blackjack Game - Spring Boot
color 0A

echo.
echo ========================================
echo    BLACKJACK GAME - SPRING BOOT
echo ========================================
echo.

echo Setting up Java 17 environment...
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
set "PATH=C:\Program Files\Java\jdk-17\bin;%PATH%"

echo.
echo Verifying Java installation...
java -version
if errorlevel 1 (
    echo ERROR: Java 17 not found!
    echo Please make sure Java 17 is installed at: C:\Program Files\Java\jdk-17
    pause
    exit /b 1
)

echo.
echo Starting Spring Boot application...
echo.
echo The game will be available at: http://localhost:8080
echo Press Ctrl+C to stop the application
echo.

call .\mvnw.cmd spring-boot:run

echo.
echo Application stopped.
pause

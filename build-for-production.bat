@echo off
title Build for Production
color 0A

echo.
echo ========================================
echo    BUILD FOR PRODUCTION
echo ========================================
echo.

echo Setting up Java 17 environment...
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
set "PATH=C:\Program Files\Java\jdk-17\bin;%PATH%"

echo.
echo Building production JAR file...
call .\mvnw.cmd clean package -DskipTests

if errorlevel 1 (
    echo.
    echo ERROR: Build failed!
    echo Please check the error messages above.
    pause
    exit /b 1
)

echo.
echo ========================================
echo    BUILD SUCCESSFUL!
echo ========================================
echo.
echo Production JAR created: target\gambling-0.0.1-SNAPSHOT.jar
echo.
echo You can now:
echo 1. Upload to GitHub
echo 2. Deploy to Heroku, Railway, or Render
echo 3. Test locally with: java -jar target\gambling-0.0.1-SNAPSHOT.jar
echo.
echo File size:
dir target\gambling-0.0.1-SNAPSHOT.jar
echo.
pause

@echo off
echo Compiling and running Blackjack Game without Maven...
echo.

REM Check if Java is available
java -version >nul 2>&1
if errorlevel 1 (
    echo Error: Java is not installed or not in PATH
    echo Please install Java 17 or higher
    pause
    exit /b 1
)

REM Create classes directory
if not exist "target\classes" mkdir target\classes

REM Compile Java files
echo Compiling Java files...
javac -cp "target\classes" -d target\classes src\main\java\com\example\gambling\*.java src\main\java\com\example\gambling\*\*.java

if errorlevel 1 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful!
echo.
echo Note: This is a simplified version. For full Spring Boot functionality, please install Maven.
echo.

REM Try to run the main class
echo Running application...
java -cp target\classes com.example.gambling.GamblingApplication

pause

@echo off
echo Setting up Java 17 environment for this session...
set "JAVA_HOME=C:\Program Files\Java\jdk-17"
set "PATH=C:\Program Files\Java\jdk-17\bin;%PATH%"

echo Java environment set successfully!
echo JAVA_HOME = %JAVA_HOME%
echo.
echo Now you can run: .\mvnw.cmd spring-boot:run
echo.

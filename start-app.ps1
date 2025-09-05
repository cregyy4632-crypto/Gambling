Write-Host "Setting up Java 17 environment..." -ForegroundColor Green
$env:JAVA_HOME = "C:\Program Files\Java\jdk-17"
$env:PATH = "C:\Program Files\Java\jdk-17\bin;" + $env:PATH

Write-Host "Verifying Java version..." -ForegroundColor Yellow
java -version
Write-Host ""

Write-Host "Starting Blackjack Spring Boot Application..." -ForegroundColor Green
Write-Host ""
Write-Host "The application will be available at: http://localhost:8080" -ForegroundColor Cyan
Write-Host "Press Ctrl+C to stop the application" -ForegroundColor Yellow
Write-Host ""

.\mvnw.cmd spring-boot:run

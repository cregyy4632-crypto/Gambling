@echo off
echo Starting Blackjack Game...
echo.
echo Make sure you have Java 17+ and Maven installed.
echo.
echo To run the application:
echo 1. Install Maven if not already installed
echo 2. Run: mvn spring-boot:run
echo 3. Open browser to: http://localhost:8080
echo.
echo API Endpoints:
echo - POST /api/blackjack/start - Start new game
echo - POST /api/blackjack/hit - Hit (draw card)
echo - POST /api/blackjack/stand - Stand
echo - GET  /api/blackjack/state - Get game state
echo - POST /api/blackjack/reset - Reset game
echo.
pause

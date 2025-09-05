@echo off
title Upload to GitHub
color 0B

echo.
echo ========================================
echo    UPLOAD TO GITHUB - BLACKJACK GAME
echo ========================================
echo.

echo Initializing Git repository...
git init

echo.
echo Adding all files to Git...
git add .

echo.
echo Creating initial commit...
git commit -m "Initial commit: Spring Boot Blackjack Game with REST API"

echo.
echo ========================================
echo    GITHUB SETUP INSTRUCTIONS
echo ========================================
echo.
echo 1. Go to https://github.com
echo 2. Click "New Repository"
echo 3. Name it: blackjack-spring-boot
echo 4. Make it PUBLIC
echo 5. DON'T initialize with README
echo 6. Click "Create Repository"
echo.
echo 7. Copy the repository URL (e.g., https://github.com/username/blackjack-spring-boot.git)
echo 8. Run these commands:
echo.
echo    git remote add origin YOUR_REPOSITORY_URL
echo    git branch -M main
echo    git push -u origin main
echo.
echo ========================================
echo    HOSTING OPTIONS
echo ========================================
echo.
echo After uploading to GitHub, you can host it on:
echo.
echo 1. RAILWAY (Easiest): https://railway.app
echo    - Connect GitHub account
echo    - Select your repository
echo    - Deploy automatically!
echo.
echo 2. HEROKU: https://heroku.com
echo    - Create account
echo    - Install Heroku CLI
echo    - Deploy with: heroku create && git push heroku main
echo.
echo 3. RENDER: https://render.com
echo    - Connect GitHub
echo    - Create Web Service
echo    - Deploy!
echo.
echo Your app will be live at: https://your-app-name.railway.app
echo.
pause

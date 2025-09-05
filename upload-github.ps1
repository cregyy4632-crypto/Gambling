Write-Host "========================================" -ForegroundColor Green
Write-Host "   UPLOAD TO GITHUB - BLACKJACK GAME" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""

Write-Host "Step 1: Initializing Git repository..." -ForegroundColor Yellow
git init

Write-Host ""
Write-Host "Step 2: Adding all files..." -ForegroundColor Yellow
git add .

Write-Host ""
Write-Host "Step 3: Creating initial commit..." -ForegroundColor Yellow
git commit -m "Initial commit: Spring Boot Blackjack Game with REST API"

Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "   GITHUB SETUP INSTRUCTIONS" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""
Write-Host "1. Go to https://github.com" -ForegroundColor Cyan
Write-Host "2. Click 'New Repository'" -ForegroundColor Cyan
Write-Host "3. Name it: blackjack-spring-boot" -ForegroundColor Cyan
Write-Host "4. Make it PUBLIC" -ForegroundColor Cyan
Write-Host "5. DON'T initialize with README" -ForegroundColor Cyan
Write-Host "6. Click 'Create Repository'" -ForegroundColor Cyan
Write-Host ""
Write-Host "7. Copy the repository URL from GitHub" -ForegroundColor Yellow
Write-Host "8. Run these commands:" -ForegroundColor Yellow
Write-Host ""
Write-Host "   git remote add origin YOUR_REPOSITORY_URL" -ForegroundColor White
Write-Host "   git branch -M main" -ForegroundColor White
Write-Host "   git push -u origin main" -ForegroundColor White
Write-Host ""
Write-Host "========================================" -ForegroundColor Green
Write-Host "   DEPLOY TO RENDER" -ForegroundColor Green
Write-Host "========================================" -ForegroundColor Green
Write-Host ""
Write-Host "After uploading to GitHub:" -ForegroundColor Cyan
Write-Host "1. Go to https://render.com" -ForegroundColor Cyan
Write-Host "2. Connect GitHub account" -ForegroundColor Cyan
Write-Host "3. Select your repository" -ForegroundColor Cyan
Write-Host "4. Deploy automatically!" -ForegroundColor Cyan
Write-Host ""
Write-Host "Your app will be live at: https://your-app-name.onrender.com" -ForegroundColor Green
Write-Host ""
Write-Host "Press any key to continue..." -ForegroundColor Yellow
$null = $Host.UI.RawUI.ReadKey("NoEcho,IncludeKeyDown")

# 📤 Manual GitHub Upload Steps

## Step 1: Open Command Prompt
1. Press `Win + R`
2. Type `cmd` and press Enter
3. Navigate to your project folder:
   ```cmd
   cd "C:\Users\ivanc\OneDrive\Desktop\Gambling"
   ```

## Step 2: Initialize Git Repository
```cmd
git init
git add .
git commit -m "Initial commit: Spring Boot Blackjack Game"
```

## Step 3: Create GitHub Repository
1. Go to [github.com](https://github.com)
2. Click the **"+"** button → **"New repository"**
3. Repository name: `blackjack-spring-boot`
4. Description: `Spring Boot Blackjack Game with REST API`
5. Make it **Public**
6. **DON'T** check "Initialize with README"
7. Click **"Create repository"**

## Step 4: Connect and Upload
After creating the repository, GitHub will show you commands. Use these:

```cmd
git remote add origin https://github.com/YOUR_USERNAME/blackjack-spring-boot.git
git branch -M main
git push -u origin main
```

Replace `YOUR_USERNAME` with your actual GitHub username.

## Step 5: Verify Upload
- Go to your GitHub repository
- You should see all your files uploaded
- The repository should show: `pom.xml`, `src/`, `target/`, etc.

---

## 🚀 Deploy to Render

### After GitHub upload:

1. **Go to [render.com](https://render.com)**
2. **Sign up/Login** with GitHub
3. **Click "New +" → "Web Service"**
4. **Connect your GitHub repository**
5. **Select your `blackjack-spring-boot` repository**
6. **Configure:**
   - **Name**: `blackjack-game`
   - **Environment**: `Java`
   - **Build Command**: `mvn clean package -DskipTests`
   - **Start Command**: `java -jar target/gambling-0.0.1-SNAPSHOT.jar`
7. **Click "Create Web Service"**

### Your app will be live at:
`https://blackjack-game.onrender.com`

---

## 🔧 Alternative: Use GitHub Desktop

If command line is difficult:

1. **Download GitHub Desktop**: [desktop.github.com](https://desktop.github.com)
2. **Install and login**
3. **Add existing repository**: Point to your project folder
4. **Publish repository**: Click "Publish repository"
5. **Deploy to Render**: Follow steps above

---

## ✅ What You're Uploading:

- ✅ Complete Spring Boot application
- ✅ RESTful API endpoints
- ✅ Modern web interface
- ✅ Production JAR file (21.8 MB)
- ✅ All configuration files
- ✅ Documentation

Your project is 100% ready for GitHub and Render!

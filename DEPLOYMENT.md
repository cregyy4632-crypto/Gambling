# 🚀 Deployment Guide - Blackjack Spring Boot Application

## 📦 **GitHub Upload**

### Step 1: Initialize Git Repository
```bash
git init
git add .
git commit -m "Initial commit: Spring Boot Blackjack Game"
```

### Step 2: Create GitHub Repository
1. Go to [GitHub.com](https://github.com)
2. Click "New Repository"
3. Name it: `blackjack-spring-boot` or `gambling-game`
4. Make it public
5. Don't initialize with README (we already have one)

### Step 3: Push to GitHub
```bash
git remote add origin https://github.com/YOUR_USERNAME/blackjack-spring-boot.git
git branch -M main
git push -u origin main
```

---

## 🌐 **Free Hosting Options**

### **Option 1: Heroku (Recommended)**
**Free tier available, easy deployment**

1. **Create Heroku account**: [heroku.com](https://heroku.com)
2. **Install Heroku CLI**: Download from [devcenter.heroku.com](https://devcenter.heroku.com/articles/heroku-cli)
3. **Create Procfile**:
   ```
   web: java -jar target/gambling-0.0.1-SNAPSHOT.jar
   ```
4. **Deploy**:
   ```bash
   heroku login
   heroku create your-blackjack-app
   git push heroku main
   ```

### **Option 2: Railway**
**Free tier available, very easy**

1. **Go to**: [railway.app](https://railway.app)
2. **Connect GitHub**: Link your repository
3. **Deploy**: Railway auto-detects Spring Boot and deploys
4. **Access**: Get your app URL (e.g., `https://your-app.railway.app`)

### **Option 3: Render**
**Free tier available**

1. **Go to**: [render.com](https://render.com)
2. **Connect GitHub**: Link your repository
3. **Create Web Service**: Select your repo
4. **Configure**:
   - Build Command: `mvn clean package`
   - Start Command: `java -jar target/gambling-0.0.1-SNAPSHOT.jar`
5. **Deploy**: Click "Create Web Service"

### **Option 4: Vercel**
**Free tier available**

1. **Go to**: [vercel.com](https://vercel.com)
2. **Import Project**: Connect your GitHub repo
3. **Configure**: Vercel will auto-detect Spring Boot
4. **Deploy**: Click "Deploy"

---

## 🐳 **Docker Deployment (Advanced)**

### Create Dockerfile
```dockerfile
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/gambling-0.0.1-SNAPSHOT.jar"]
```

### Deploy to Docker Hub
```bash
docker build -t your-username/blackjack-game .
docker push your-username/blackjack-game
```

---

## ⚙️ **Configuration for Production**

### Update application.properties
Create `src/main/resources/application.properties`:
```properties
# Server configuration
server.port=${PORT:8080}

# Logging
logging.level.com.example.gambling=INFO
logging.level.org.springframework=WARN

# CORS for production
spring.web.cors.allowed-origins=*
spring.web.cors.allowed-methods=GET,POST,PUT,DELETE,OPTIONS
spring.web.cors.allowed-headers=*
```

---

## 🔧 **Build for Production**

### Create Production JAR
```bash
.\mvnw.cmd clean package -DskipTests
```

This creates: `target/gambling-0.0.1-SNAPSHOT.jar`

### Test Production Build
```bash
java -jar target/gambling-0.0.1-SNAPSHOT.jar
```

---

## 📱 **Mobile-Friendly Features**

Your app already includes:
- ✅ Responsive design
- ✅ Mobile-friendly interface
- ✅ Touch-friendly buttons
- ✅ Optimized for all screen sizes

---

## 🎯 **Quick Deploy Commands**

### For Heroku:
```bash
# Add to your project
echo web: java -jar target/gambling-0.0.1-SNAPSHOT.jar > Procfile

# Deploy
git add .
git commit -m "Add Procfile for Heroku"
git push heroku main
```

### For Railway:
```bash
# Just push to GitHub, Railway handles the rest!
git push origin main
```

---

## 🌟 **Your App Will Be Available At:**

- **Heroku**: `https://your-app-name.herokuapp.com`
- **Railway**: `https://your-app-name.railway.app`
- **Render**: `https://your-app-name.onrender.com`
- **Vercel**: `https://your-app-name.vercel.app`

---

## 🎮 **Features Ready for Production:**

- ✅ Complete blackjack game logic
- ✅ RESTful API endpoints
- ✅ Modern web interface
- ✅ Mobile responsive design
- ✅ Session-based gameplay
- ✅ Error handling
- ✅ CORS enabled for web access

---

## 🚀 **Recommended: Railway (Easiest)**

1. **Upload to GitHub** (follow steps above)
2. **Go to Railway.app**
3. **Connect GitHub**
4. **Select your repository**
5. **Deploy** (automatic!)
6. **Get your live URL**

Your Spring Boot application will be live on the internet in minutes!

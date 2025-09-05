# 🎯 Quick Start Guide - Blackjack Spring Boot Application

## ✅ **WORKING SOLUTION**

### **Step 1: Set up Java Environment**
Run this command in PowerShell or Command Prompt:
```cmd
.\setup-java.bat
```

### **Step 2: Start the Application**
```cmd
.\mvnw.cmd spring-boot:run
```

### **Step 3: Access Your Game**
- Open your browser and go to: **http://localhost:8080**
- Or open `test-api.html` to test the REST API

---

## 🚀 **Alternative Methods**

### **Method 1: One-Command Start**
```cmd
.\run-blackjack.bat
```
*This will set up Java and start the application automatically*

### **Method 2: PowerShell Script**
```powershell
.\start-app.ps1
```

### **Method 3: Manual Setup**
1. Open Command Prompt (not PowerShell)
2. Run:
   ```cmd
   set JAVA_HOME=C:\Program Files\Java\jdk-17
   set PATH=C:\Program Files\Java\jdk-17\bin;%PATH%
   .\mvnw.cmd spring-boot:run
   ```

---

## 🎮 **What You'll See**

1. **Maven will download dependencies** (first time only)
2. **Spring Boot will start** with startup messages
3. **Look for**: "Started GamblingApplication" message
4. **Application will be available at**: http://localhost:8080

---

## 🛠️ **Troubleshooting**

### If you get "JAVA_HOME is not set" error:
- Make sure you ran `.\setup-java.bat` first
- Or use `.\run-blackjack.bat` instead

### If the application doesn't start:
- Check if port 8080 is in use: `netstat -an | findstr :8080`
- Kill existing Java processes: `taskkill /F /IM java.exe`

### If you can't access the web page:
- Wait 30-60 seconds for full startup
- Check console for error messages
- Make sure you're using `http://localhost:8080`

---

## 🎯 **API Endpoints**

Once running, test these endpoints:
- `POST http://localhost:8080/api/blackjack/start` - Start new game
- `POST http://localhost:8080/api/blackjack/hit` - Hit (draw card)  
- `POST http://localhost:8080/api/blackjack/stand` - Stand
- `GET http://localhost:8080/api/blackjack/state` - Get game state
- `POST http://localhost:8080/api/blackjack/reset` - Reset game

---

## 🛑 **Stopping the Application**

- Press `Ctrl + C` in the command window
- Or close the command window

---

## 🎉 **Success!**

Your Spring Boot Blackjack application is now running and ready to be uploaded to GitHub!

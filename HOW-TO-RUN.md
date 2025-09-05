# How to Run Your Blackjack Spring Boot Application

## Method 1: Manual Setup (Recommended)

1. **Open Command Prompt (not PowerShell)**
   - Press `Win + R`, type `cmd`, and press Enter

2. **Navigate to your project folder**
   ```cmd
   cd "C:\Users\ivanc\OneDrive\Desktop\Gambling"
   ```

3. **Set Java 17 environment variables**
   ```cmd
   set JAVA_HOME=C:\Program Files\Java\jdk-17
   set PATH=C:\Program Files\Java\jdk-17\bin;%PATH%
   ```

4. **Verify Java version**
   ```cmd
   java -version
   ```
   You should see Java 17.0.12

5. **Run the application**
   ```cmd
   .\mvnw.cmd spring-boot:run
   ```

6. **Access the game**
   - Open your browser and go to: `http://localhost:8080`
   - Or open `test-api.html` to test the API

## Method 2: Using Batch File

1. **Double-click `run-blackjack.bat`**
   - This will open a command window and start the application

2. **Wait for the application to start**
   - You'll see Spring Boot startup messages
   - Look for "Started GamblingApplication" message

3. **Access the game**
   - Open your browser and go to: `http://localhost:8080`

## Method 3: Using PowerShell

1. **Open PowerShell**
   - Right-click on the project folder and select "Open PowerShell window here"

2. **Run the PowerShell script**
   ```powershell
   .\start-app.ps1
   ```

## Troubleshooting

### If you get "JAVA_HOME is not set" error:
- Make sure you're using Command Prompt (cmd), not PowerShell
- Run the environment setup commands manually:
  ```cmd
  set JAVA_HOME=C:\Program Files\Java\jdk-17
  set PATH=C:\Program Files\Java\jdk-17\bin;%PATH%
  ```

### If the application doesn't start:
- Check if port 8080 is already in use:
  ```cmd
  netstat -an | findstr :8080
  ```
- Kill any existing Java processes:
  ```cmd
  taskkill /F /IM java.exe
  ```

### If you can't access the web page:
- Wait a few seconds for the application to fully start
- Check the console output for any error messages
- Make sure you're using `http://localhost:8080` (not https)

## API Endpoints

Once running, you can test these endpoints:
- `POST http://localhost:8080/api/blackjack/start` - Start new game
- `POST http://localhost:8080/api/blackjack/hit` - Hit (draw card)
- `POST http://localhost:8080/api/blackjack/stand` - Stand
- `GET http://localhost:8080/api/blackjack/state` - Get game state
- `POST http://localhost:8080/api/blackjack/reset` - Reset game

## Stopping the Application

- Press `Ctrl + C` in the command window where the application is running
- Or close the command window

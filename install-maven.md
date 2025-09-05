# Installing Maven on Windows

## Option 1: Using Chocolatey (Easiest)
1. Open PowerShell as Administrator
2. Install Chocolatey if you don't have it:
   ```powershell
   Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://community.chocolatey.org/install.ps1'))
   ```
3. Install Maven:
   ```powershell
   choco install maven
   ```

## Option 2: Manual Installation
1. Download Maven from: https://maven.apache.org/download.cgi
2. Extract to C:\Program Files\Apache\maven
3. Add C:\Program Files\Apache\maven\bin to your PATH environment variable
4. Restart Command Prompt/PowerShell

## Option 3: Using SDKMAN (Alternative)
1. Install SDKMAN: https://sdkman.io/install
2. Install Maven: `sdk install maven`

## Verify Installation
After installation, run:
```cmd
mvn --version
```

You should see Maven version information.

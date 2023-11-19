# HealthChecker

This repo contains code that reads a YAML file and performs certain actions based on the file. The code is written in Java. The YAML file defines http requests with parameters such as URL, Body, Method, Headers, etc. The set of requests are sent every 15 seconds, and availability of the domains is calculated based on a certain formula.

## Prerequisites
1. Java JDK (openjdk-21 Oracle OpenJDK version 21.0.1)
2. Maven (Apache Maven 3.9.5)

## Installing OpenJDK 21
I recommend installing IntelliJ IDEA and using the OpenJDK 21 21.0.1 version for your system. That is the easiest way to use open jdk. An alternative to this is to go to this website: https://jdk.java.net/21/, and install the correct version as per your system.

If you have downloaded jdk from the above website, follow these instructions to update Java variable:

### For macOS Users
1. Extract the JDK: If the JDK was downloaded as a compressed file, extract it to a suitable location on your system.
2. Set the JAVA_HOME Variable:  
    a. Open Terminal  
    b. Use a text editor (like nano or vim) or open your shell's profile file (~/.bash_profile, ~/.bashrc, or ~/.zshrc).  
    c. Add the following line:  
        `export JAVA_HOME=/path/to/your/jdk-21.0.1.jdk/Contents/Home`  
        Replace /path/to/your/jdk-21.0.1.jdk/Contents/Home with the actual path to the extracted JDK directory. Save the file and exit the editor. Run source ~/.bash_profile (or the respective profile file) to apply the changes to the current terminal session.
3. Verify Java Installation:  
    a. Open a new terminal window or tab.  
    b. java -version  
  It should display the installed Java version (21.0.1).

### For Windows Users
1. Install the JDK
2. Double-click the downloaded JDK installer (jdk-21.0.1_windows-x64_bin.exe).
3. Follow the installation wizard, selecting the installation directory.
4. Set JAVA_HOME Environment Variable:  
    a. Right-click on "This PC" or "My Computer" and select "Properties."  
    b. Click on "Advanced system settings."  
    c. Click on "Environment Variables."  
    d. Under "System Variables," click "New" and add a variable with:  
    e. Variable name: JAVA_HOME  
    f. Variable value: Path to your JDK directory (e.g., C:\Program Files\Java\jdk-21.0.1).  
    g. Click "OK" to save the variable.  
5. Update PATH Variable:  
    a. Find the "Path" variable under "System Variables" and click "Edit."  
    b. Add %JAVA_HOME%\bin to the list of paths.  
    c. Click "OK" to save changes.  
6. Verify Java Installation:  
    a. Open cmd. Type this: java -version. It should display the installed Java version (21.0.1).

## Installing Maven
### For Linux Users
1. Open Terminal.
2. Run the following commands:
   a. sudo apt update
   b. sudo apt install maven

### For macOS Users (using Homebrew)
1. Open Terminal.
2. Run the following command:
   a. brew install maven

### For Windows Users (using Chocolatey)
1. Open Command Prompt or PowerShell as Administrator.
2. Run the following command:
   a. choco install maven

## Cloning the Repository

Clone this repository to your local machine:
1. git clone https://github.com/suyash0103/HealthChecker.git
2. cd HealthChecker

## Building and Running the Application

After installing Maven and cloning navigate to the project directory in your terminal or command prompt.

Run the following commands:  
`mvn clean compile`
`mvn exec:java -Dexec.mainClass="org.fetch.Main" -Dexec.args="./request.yaml"`

The request.yaml files includes a set of apis that were developed by me. If you want to replace these apis with a different set of apis, please update the request.yaml file. Also, if you want to move the request.yaml file to some other location in your system, feel free to do so, just update the file path in the -Dexec.args argument.

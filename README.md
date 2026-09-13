# CodeDetective — Interactive Java Debugging & Learning System

## 1. Project Overview

CodeDetective is a command-line-based Java debugging and learning system designed to help students improve their Java programming and debugging skills through an interactive detective-style experience.

The system presents users with different debugging cases containing broken Java code, programming stories, error messages, and evidence. The user acts as a detective and must analyze the given code, identify the bug, and understand the correct solution.

The project combines Java programming concepts with gamification features such as XP, levels, ranks, achievements, hints, streaks, random challenges, and progress tracking.

The application is designed to be simple enough for beginners while demonstrating important Java concepts such as Object-Oriented Programming, inheritance, abstraction, interfaces, polymorphism, exception handling, collections, file handling, and modular program design.

---

## 2. Problem Statement

Many beginners learn Java syntax and programming concepts but find it difficult to identify and understand errors in real programs.

Traditional programming exercises often focus on writing code from scratch rather than analyzing existing faulty code. This makes debugging difficult for students who are still developing problem-solving skills.

CodeDetective addresses this problem by providing an interactive environment where students investigate broken Java programs, analyze evidence, identify bugs, and learn how to repair them.

---

## 3. Features

### Debugging Case System

* Multiple Java debugging cases.
* Each case contains a story, broken code, evidence, and difficulty level.
* Cases cover different categories of programming errors.

### Bug Detection

Users enter their diagnosis of the suspected bug. The system validates the answer using predefined keywords.

### Hint System

Players can request hints when they are stuck. Using a hint consumes XP.

### XP and Level System

Correctly solving cases awards XP according to their difficulty.

### Detective Ranks

The player's rank changes as their XP increases.

Example ranks:

* Rookie Detective
* Junior Debugger
* Code Sleuth
* Bug Hunter
* Senior Detective
* Code Master

### Achievement System

Achievements are unlocked as the player reaches different milestones.

Examples:

* First Blood
* Bug Hunter
* Master Detective
* Three Case Streak
* No Hints Needed

### Random Case

The system can select an unsolved case randomly.

### Daily Challenge

A date-based challenge provides a special debugging assignment.

### Case History

The player can view their solved cases and overall progress.

### Save Progress

Player information can be stored in a local file and recovered when the program is started again.

### Error Handling

Invalid menu input and file-related errors are handled using Java exception handling.

---

## 4. Major Functional Modules

### Module 1 — Case Investigation

Responsible for:

* Displaying cases
* Showing broken code
* Displaying evidence
* Accepting bug diagnosis
* Validating answers
* Showing repairs and explanations

### Module 2 — Detective Progress

Responsible for:

* XP calculation
* Levels
* Ranks
* Streaks
* Achievements
* Hints
* Attempts

### Module 3 — Challenge and Data Management

Responsible for:

* Random case selection
* Daily challenges
* Case history
* Saving progress
* Loading previous progress

---

## 5. Technologies and Tools Used

### Programming Language

* Java 17

### Core Java Concepts

* Classes and Objects
* Constructors
* Encapsulation
* Inheritance
* Abstract Classes
* Interfaces
* Polymorphism
* ArrayList
* Exception Handling
* File I/O
* Randomization
* Date Handling

### Development Tools

* Visual Studio Code / Any Java-compatible IDE
* Java Development Kit (JDK) 17
* Command Prompt or PowerShell
* Git
* GitHub

### Storage

* Local text-file storage

---

## 6. System Requirements

The project requires:

* Java JDK 17 or later
* Windows, Linux, or macOS
* Command-line terminal
* Git (optional for running locally, required for repository management)

To verify Java installation:

```bash
java -version
```

To verify the Java compiler:

```bash
javac -version
```

Both commands should display Java version information.

---

## 7. Installation

### Step 1 — Clone the Repository

Clone the GitHub repository using:

```bash
git clone <YOUR_GITHUB_REPOSITORY_URL>
```

Move into the project directory:

```bash
cd CodeDetective
```

### Step 2 — Compile the Project

If the source files are in the same directory:

```bash
javac *.java
```

If using the recommended package structure:

```bash
javac -d out src/codedetective/*.java
```

### Step 3 — Run the Application

For a simple single-directory setup:

```bash
java CodeDetective
```

For the package-based setup:

```bash
java -cp out codedetective.CodeDetective
```

---

## 8. How to Use the Application

After starting the program, the user is asked to enter a detective name.

Example:

```text
========================================
           CODEDETECTIVE
      Java Debugging Learning Game
========================================
Enter detective name: KD
```

The main menu then appears:

```text
============== MAIN MENU ==============
1. Investigate a Case
2. Random Case
3. Daily Challenge
4. Detective Profile
5. Case History
6. Achievements
7. Save Progress
8. How To Play
9. Exit
========================================
```

### Investigating a Case

Select:

```text
1. Investigate a Case
```

Choose a case number.

The application displays:

* Case title
* Story
* Broken Java code
* Evidence
* Bug category
* Difficulty

The user then submits a diagnosis.

Example:

```text
What is the bug? division by zero
```

If the diagnosis is correct, the case is solved and XP is awarded.

---

## 9. Hint System

During an investigation, the user can select:

```text
2. Request Hint
```

A hint is displayed and XP is deducted.

The hint system encourages users to solve cases independently while still providing assistance when necessary.

---

## 10. Testing Instructions

Testing can be performed directly from the command line.

### Test 1 — Application Startup

Run:

```bash
java CodeDetective
```

Expected result:

The CodeDetective welcome screen should appear and request the detective's name.

### Test 2 — Case Selection

Select:

```text
1. Investigate a Case
```

Then enter a valid case number.

Expected result:

The selected case, broken code, evidence, and difficulty should be displayed.

### Test 3 — Correct Diagnosis

For the division-by-zero case, enter:

```text
division by zero
```

Expected result:

The system should mark the case as solved and award XP.

### Test 4 — Incorrect Diagnosis

Enter an unrelated answer.

Expected result:

The system should display:

```text
Incorrect diagnosis.
```

The user should be allowed to try again.

### Test 5 — Invalid Menu Input

Enter an invalid menu value such as:

```text
99
```

Expected result:

The application should display an invalid-option message without crashing.

### Test 6 — Hint

Select:

```text
2. Request Hint
```

Expected result:

A hint should be displayed and 15 XP should be deducted when sufficient XP is available.

### Test 7 — Random Case

Select:

```text
2. Random Case
```

Expected result:

An unsolved case should be selected randomly.

### Test 8 — Profile

Select:

```text
4. Detective Profile
```

Expected result:

The system should display the detective's name, rank, level, XP, solved cases, attempts, hints, and streak.

### Test 9 — Achievements

Select:

```text
6. Achievements
```

Expected result:

Unlocked and locked achievements should be displayed.

### Test 10 — Save Progress

Select:

```text
7. Save Progress
```

Expected result:

A local save file named:

```text
detective_save.txt
```

should be created.

### Test 11 — Load Progress

Close and restart the application after saving.

Expected result:

Previously saved detective information should be loaded.

---

## 11. Example Debugging Case

Example case:

```text
CASE #1 : The Divided Number

Broken Code:

int a = 20;
int b = 0;
int result = a / b;
System.out.println(result);

Evidence:

java.lang.ArithmeticException: / by zero
```

Possible diagnosis:

```text
division by zero
```

The system identifies the diagnosis as correct and displays the explanation and repair.

---

## 12. Project Structure

The recommended project structure is:

```text
CodeDetective/
│
├── README.md
├── statement.md
├── .gitignore
│
├── src/
│   └── codedetective/
│       ├── CodeDetective.java
│       ├── GameEngine.java
│       ├── Detective.java
│       ├── CaseFile.java
│       ├── Bug.java
│       ├── RuntimeBug.java
│       ├── LogicBug.java
│       ├── CompileBug.java
│       ├── ConceptBug.java
│       ├── Debuggable.java
│       └── SaveManager.java
│
├── data/
│   └── cases.txt
│
├── screenshots/
│
└── docs/
    └── diagrams/
```

---

## 13. Screenshots

The following screenshots are recommended for documenting the project:

1. Application welcome screen
2. Main menu
3. Case selection screen
4. Broken Java code and evidence
5. Correct diagnosis
6. XP and rank update
7. Detective profile
8. Achievement screen
9. Case history
10. Save-progress confirmation

Screenshots can be placed inside the `screenshots/` directory.

Example:

```text
screenshots/
├── welcome.png
├── main-menu.png
├── case-investigation.png
├── solved-case.png
├── profile.png
└── achievements.png
```

---

## 14. Learning Outcomes

Through this project, the developer gains practical experience with:

* Java Object-Oriented Programming
* Error identification and debugging
* Exception handling
* File handling
* Data structures
* Modular programming
* User input validation
* Software design
* Git and GitHub
* Testing and documentation

---

## 15. Future Enhancements

Possible future improvements include:

* JavaFX graphical interface
* MySQL database using JDBC
* User authentication
* Online leaderboard
* Larger debugging case library
* Automatic Java code compilation and testing
* AI-assisted bug explanations
* Difficulty adaptation based on user performance
* Multiplayer debugging competitions
* Web-based version

---

## 16. Author

**Kaustubh Duratkar**
B.Tech CSE AIML
VIT Bhopal University
Registration No.: 25BAI10592

---

## 17. License

This project is developed as an academic project for educational purposes.

# About The Project 
This repository contains a group project for Computer Science 127 focused on object-oriented programming in Java. The project is a simple randomized game inspired by hidden mines. The player interacts with a grid of tiles and must click on tiles to reveal them. The goal is to select safe tiles while avoiding one hidden tile that contains a mine. If the player clicks the mine, the game ends (they “blow up”). The project demonstrates key concepts such as classes, objects, event handling, and randomness in Java. 

# Required Software
To run the project, the following software must be installed:
* OpenJDK version 25.0.1 (LTS, released October 21, 2025)
* Visual Studio Code version 1.115.0

Additionally, you will need:
* Java extensions for VS Code (Extension Pack for Java)
* Any required course libraries (such as the Macalester graphics library, if used)

## Built With
* GitHub
* GitHub Desktop
* Visual Studio Code
* Adoptium - Java Download

# Setup Instructions 
Follow this setup guide (as required):
https://shilad.github.io/workflow-wizard-walkthrough/?step=welcome

Then complete these steps:
1. Install OpenJDK and verify installation using:

 java -version


2. Install Visual Studio Code.
3. Install the Java Extension Pack in VS Code.
4. Clone or download the GitHub repository.
5. Open the project folder in VS Code.
6. Make sure all required libraries (such as graphics libraries) are included in the project.
7. Locate the main class (e.g., MineGame.java).
8. Click “Run” or use the terminal to compile and run:

  MineGame.java

# How to Run the Code
Once everything is set up:
* Run the main Java file.
* A window (canvas) should appear displaying a grid (for example, 3x3 tiles).
* Click on tiles:
  - Safe tiles will change color (e.g., turn green).
  - Clicking the mine will trigger a “game over” event.

# Expected Output 
The program opens a graphical window that includes:
* A grid of tiles (e.g., 3x3)
* Interactive mouse-click functionality
* Visual feedback:
  - Safe tile → changes color (green)
  - Mine tile → triggers loss condition
( insert screenshots here of the game window while running.)

# Known Limitations 
The current version of the software has some limitations:
* Only one mine is implemented (no difficulty levels)
* Grid size is fixed (e.g., 3x3)
* No restart or reset button
* No score tracking or progression system
* Minimal UI (no instructions displayed in-game)
* Possible bugs with click detection or tile state updates
* No sound effects or animations

# Resources Used
The following resources were referenced during development:
* Course materials from Macalester College Computer Science 127
* Java documentation
* The setup guide: https://shilad.github.io/workflow-wizard-walkthrough/?step=welcome
* VS Code Java Extension documentation
* Help from classmates and group collaboration

# Presentation Video 

# Presentation Slides












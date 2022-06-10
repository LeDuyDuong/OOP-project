### OOP Final Project
# IU DETECTIVE
## 1. Team Đổ 5 Nghìn Nó Không Cho Đổ
Contributors
- Lê Đào Thành Vinh - ITITIU20353 lead
- Hồ Hữu Hiệp - ITITIU20202
- Lê Duy Dương - ITITUN20004
- Võ Thành Khoa - ITITSB20002
## 2. Introduction
### a. Motivation
The name of our game is IU Detective which somewhat demonstrates the main purpose of playing this game. Recently, there have been many cases in which IU students’ properties get stolen by some thieves at the campus.  This reason is a partial motivation for us to create this small detective and problem-solving games.
### b. Brief description
- In this game, the player will control the main character – a student detective to find out who is truly the thief of a stolen backpack case with some hints, evidences as well as guides to solve some riddles provided by the game. Moreover, the player has to collect useful tools on the way or to interact with other characters like students and lecturers or objects like opening/close the door, turning on/off something and extract information by reading some letters or description about something.
- The game is a 2D pixel game and its environment will mimic the actual infrastructure of IU. Therefore, this game will allow us to visit the campus virtually while we enjoy playing it. Especially, due to the Covid-19, many subjects have to be conducted online for the students and they may not have a chance to go to the campus frequently. This game will be a fine solution for this situation.
## 3. Draft features
#### a. Primary features
- Interact: The players can interact items to find clues.
- Move: The players can move any directions they can.
- Items: IT can be a clue, introduction of place.
- Notification: It can be a notice items, alarm, when you finish or accept any missions.
- NPC: Other students or teachers.
#### b. Secondary features
- Map: Show the location where we are standing.
- Time: Real time or time in game.
- Change characters: The appearances can be change.
#### c. 
## 4. References & Materials
#### a. Language: Java with JDK-17.0.2
#### b. Library: Standard GUI (AWT and SWING)
- To set up game panel and many maps with two-dimension coordinates.
- To set up borders for many tiles placed in the maps.
- To Define a core borders for NPCs, Objects as well as Players. This is actually useful for implementing collision checker
#### c. IDE: IntelliJ
#### c. What would our game look like:
![image](https://user-images.githubusercontent.com/86940283/163815875-0b90166e-bbaa-4da0-a36d-0cf9a77a5695.png)
![image](https://user-images.githubusercontent.com/86940283/163815891-e7502b6a-3810-4c30-8bb4-f63012bccd7c.png)
![image](https://user-images.githubusercontent.com/86940283/163815904-4e08bdb9-9ba0-4ce2-a523-a3167663424c.png)
![image](https://user-images.githubusercontent.com/86940283/163815914-d19d14d7-1bca-4d04-8e10-d3e7e2e7edb6.png)
### d. References: 
#### Tom Huynh's Lessons
#### Youtube Channel: RyiSnow (https://www.youtube.com/channel/UCS94AD0gxLakurK-6jnqV1w)
#### List of video used: https://www.youtube.com/watch?v=om59cwR7psI&list=PL_QPQmz5C6WUF-pOQDsbsKbaBZqXj4qSq&ab_channel=RyiSnow

## 5. UML Diagram

All object classes or NPC classes derive from the abstract class Entity in the UML schema of the project. In this, each class object is responsible for drawing a single object, and each class NPC is responsible for creating distinct NPCs.Drawing maps, drawing messages, interacting, moving, colliding, and running programs, on the other hand, are all independent classes that are not inherited into any abstract classes. These classes play an essential part in laying the groundwork for the game, and the Entity class and its descendants will continue to grow to make the game more distinctive.


![image](https://user-images.githubusercontent.com/92241573/172813439-c96c8617-25fb-472a-a065-5c8368088775.png)

## 6. Complete and Incomplete Features
Currently, we have finished our initially planned features which are essential for this game performance.
 - Firstly, KeyHandler and KeyListener are responsible for main player's movement, interaction with NPCs and objects, pausing the game, exit to the menu screen, opening inventory,...
![image](https://user-images.githubusercontent.com/91868954/172844299-f583bf09-1517-4f6e-892e-bb02a68d7253.png)
![image](https://user-images.githubusercontent.com/91868954/172844692-d187edad-c5d1-4391-9b85-1ecf3c75ab9d.png)

 - Secondly, EventHandler is conducted as a tool to solve any requirement for state changes like switch two other maps whenever player enters elevators or rooms, or prevent the game from running when key P is pressed or switching to menu screen.
   ![image](https://user-images.githubusercontent.com/91868954/172846186-33b21906-7cf3-46ce-9f4a-9730cb4b72fa.png)
![image](https://user-images.githubusercontent.com/91868954/172846077-f2a07b5e-9db1-4c3d-9a6f-9a3d1df1ac21.png)
![image](https://user-images.githubusercontent.com/91868954/172845982-fd24df0b-29e0-441d-8567-f3125ebf1c70.png)

 - Thirdly, we have to set up AssetSetter to place the NPCs and objects on the map based on the given coordinates from user. Additionally, our maps are simply made of two-dimensional array and each map has the same size 36x36 tiles (each tile is 16x16 bits and they are scaled up to 3 times). At this point, we simply place appropriately the border tiles to prevent player from stepping out the maps.
   ![image](https://user-images.githubusercontent.com/91868954/172845504-7ce526f7-a5a5-485c-9aa5-fa19dcd7809c.png)

   ![image](https://user-images.githubusercontent.com/91868954/172845790-47a96dc2-96db-4f31-86c9-e06ebe2ebb55.png)
 - Finally, to detect which tiles are borders or just simple the object that the player cannot cross it physically, we implement the CollisionChecker. Other features are Sound and UI used to draw dialogues for NPCs, inventory, and set up background musics and  sound effects when player opens door or enter elevators
   ![image](https://user-images.githubusercontent.com/91868954/172845725-be8760fd-2729-4906-9fad-950212b2e150.png)
Apparently, there are multiple possible and intriguing features and mechanism for us to develop in the future. As mentioned before, this is a puzzle-solving game. However, our puzzles implemented for this game are extremely simple as the solution for those puzzles are mainly movements and based on the real-life quiz and codes. Hence, player only needs to solve it on paper or immediately in their brain and then move their character instead of following a mechanism of the game like some classic games Minesweeper or Ice Cube Sliding. Maybe we will develop many more difficult puzzles in those classrooms. Moreover, we did not make a settings or options interface for users to adjust volume of the sounds or change the way character moves, zoom in and zoom out the map and the fullscreen mode.

## 7. Challenges and Experience
- The most difficult parts of this project is to initialize the tool classes in package Main. Beside the main tutorials that we follow above, we watch a lot of Youtube videos related to many other perspectives which are not explained deeply in the tutorials and view many solutions from StackOverflow. Furthermore, everyone has to understand the functionalities of those classes to finish further pieces of features made by those tools. This means reviewing the source code is very important and time-consuming.
- After decided to choose a game with a specific mechanism and tutorials on Youtube, we have to learn how to use GitHub. It is not difficult but somewhat annoying at the first time of using as we do not actually understand a smooth workflow for a project. As a result, we recreate up to 4 repositories and fix several conflicts as well as create and delete a lot of branches. However, in the end, we now understand how to use GitHub's basic functions and understand the workflow more properly. 

## 8. Final Project
This is the link leading to our walk-through video for this game
https://drive.google.com/file/d/1wfNLqe5NwakAdCG6VSkt2R15hA6IovdN/view?usp=sharing
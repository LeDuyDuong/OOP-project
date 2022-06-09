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
## 3. Features
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

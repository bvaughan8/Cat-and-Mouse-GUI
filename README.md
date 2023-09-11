# Project 2


## Help Received

Please document any help you received in completing this lab. Note that the what you submit should be your own work. Refer to the syllabus for more details. 

I worked alone

## Describe your work


## Part 1: UML Diagram

Note that you must do two tasks here:

1. Add to your repo a document `UML.png` that is a image of your UML diagram
2. Update the document `OOP-design.md` that describes your OOP design, referencing your document.
3. You will receive feedback on your design in a github issue

For your final submission, please update `UML.png` with the final UML diagram and `OOP-design.md` with your final description. Below describe the major changes you made.

For the Cat class I added two more member variables ate of boolean type and currentChasing of creature type. In that class I changed randomTurn() to changeDir(), eatMouse() to eat(), and turnsZombie() to zombie(). For the Mouse class I only changed two methods from randomTurn() to changeDir() and newMouse() to babyMouse(). In the ZombieCat class I added three member variables ate, currentChasing and round. In the Dog class I added 2 member vairables round and currentChasing and then I got rid of the search() method.

## Part 2: Implementation

What level simulation did you achieve

Level : 4 

If you completed Level 4, describe the additional creature you added to the simulation.

The creature I created was a Dog. A Dog only eats ZombieCats and can jump 4 spaces at a time. However if a Dog is within a distance of 3 it jumps 1 space at a time. When not chasing a Dog is green but turns magenta when it has found a ZombieCat to chase. A dog also lives forever and whenever they eat a ZombieCat a new dog is produced in the spot the ZombieCat died.


# OOP Design Document

[https://github.com/cs2113-s22/project-2-bvaughan8/blob/main/UML.png]

## Overview

In my OOP design Creature will be the parent class that all other classes will extend from. Classes like Cat, Mouse, ZCat, and Dog will all inherit methods and variables from Creature and then will use polymorphism to make the inherited methods suit their individual need.

## Creature
Creature will be the parent class which all animals will extend from. It is also the class that contains all the functions that most child classes will use but each child class may have changes to certain methods to meet a specific need. It also has multiple member variables that will all be utilized by child classes.

## Cat
Cat will be a child class of creature. It will have three additional member variables round that keeps track of the number of rounds passed, ate to keep track if they have ate or not, and currentChasing to keep track of the mouse they are trying to eat. In the Cat classes it takes advantage of inheritance by inheriting many variables that were used in Creature parent class. It will also use polymorphism when the Cat class inherits methods like step, takeAction, and randomTurn which will be similar to the parent method but work slightly differently by having the Cat object take different steps, or having a differnet chance of turning.

## Mouse
Mouse will be a child class of creature. It will have an additional member variable round that keeps track of the number of rounds passed. In the Mouse class it takes advantage of inheritance by inheriting many variables that were used in Creature parent class. It will also use polymorphism when the Mouse class inherits methods like step, takeAction, and randomTurn which will be similar to the parent method but work slightly differently by having a differnet step pattern and chance that it will turn or not.

## ZombieCat
ZombieCat will be a child class of Cat. In the ZombieCat class it takes advantage of inheritance by inheriting many variables that were used in Creature and Cat parent classes. It will also use polymorphism when the ZombieCat class inherits methods like chase, step, and takeAction which will be similar to the parent method but work slightly differently like chase since a ZombieCat can chase and eat both cats and mice.

## Dog
The dog class will extend from Creature. This Dog object will search for and chase a ZombieCat from any range. When it eats a ZCat and new Dog will be created in the same spot the ZCat was eaten at. It will take advantage of polymorphism by using the inherited class step(), and takeAction but will work differently since it has differnet requirements.
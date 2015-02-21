An Implementation of Battleships with Akka Actors and Scala
===========================================================

## The Basic Rules
This game is played by a 2 players on two grids with 5 ships each.

## The Grid
* The grid is made up of ten rows and ten columns.
* One grid has to be hidden from a player's opponent and displays the players ship placement.
* The other grid is for the opponent to aim at and fire at a players ship

## The Ships
* Each player gets 5 ships broken down into the following
	* One 5 length ship
	* One 4 length ship
	* Two 3 length ship
	* One 2 length ship
* The player can place a ship on 'his/her' grid (the one not visible to the opponents).
* Each ship will occupy the number of squares for it's size so a 5 length ship will occupy 5 squares on the grid.
* A ship can be placed either vertically or horizontally and cannot hang off the grid nor can they be placed diagonally.
* Ships can be placed side by side or any distance apart as long as the previous rule is not broken, but they cannot overlap.

## Gameplay
* Players take turns to fire shots at their opponent ships. On the grid that does not display that opponent's ships.

* They do so by guessing where an opponent's ships might be and their aim is to completely obliterate a ship.

* A player marks a shot on his/her grid and the system must let that player know if it was a hit or a miss. 

* A ship is sunk if all the squares it occupies are hit.

* A distinction must be made between hits and misses.

### Salvo Variant (to be implemented in version 2)
To speed up the game a player is allowed to fire as many shots as ships that he/she has in the game the number of shots are directly proportional to the number of ships he/she has available. For example if a player has 5 ships he/she is allowed to fire 5 shots at the opponent, 4 ships will only allow a player 4 shots and so on.

## Miscellaneous
### Types of ships
* Aircraft Carrier (5 length) - This is the Super Carrier class
* Battleship (4 length) - This will be our Dreadnought class
* Submarine (3 length) - This will be our U-Boat class
* Destroyer (3 length) - This will be a Neutrashimy
* Patrol Boat (2 length) - This will be the Sentinel class


## Setting up Project on Intellij
Clone the repository to your workspace and import the build.sbt into Intellij and the IDE will do the rest.

#Cell Implementation

We can implement the cell as a Finite State Machine (FSM) Akka provides and FSM library with extends the Actor trait.

##States
At the moment there are 4 states that a cell can be in
* Vacant - the cell has no ships on it
* Occupied - the cell has a ship on it
* Active - the cell has not been fired at
* Inactive - the cell has been fired at

##Logic


    If the cell was in an occupied state and was fired at, it becomes inactive and sends 
    a message to the occupier that it's been hit
    
	If the cell was in a vacant state and was fired on, the cell becomes inactive
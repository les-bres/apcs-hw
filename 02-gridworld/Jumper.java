import info.gridworld.actor.*;

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;


/*
CLASS JUMPER:
Actor can move forward 2 cells in each move, jumping over rocks and flowers, witout leaving anything behing.

1. Problem Details:
a) if the location two cells in front contains a flower, the jumper will replace that flower, but if it contains a rock, it will rotate right 45 degrees
b) if the location two cells in front of the jumper is out of the grid, it will rotate right 45 degrees
c) if the jumper is facing an edge of the grid, it will rotate right 45 degrees
d) if another actor is in the cell two cells in front of the jumper, the jumper will rotate right 45 degrees
e) if the jumper encounters another jumper in its path, one of the jumpers wil continue forward while the other turns right 45 degrees
f) it can also jump over other actors

2. Design:
a) Jumper should extend class actor
b) the bug class is very similar to the jumper class
c) there can be a parameter to set the color or just a default
d) the act method needs to be overridden  
e) a turn method, jump method, and canJump method need to be added
f) to test the class i will first place the jumper on a grid and invoke the run method.  I will then move them and make sure the following scenarios are accounted for: surrounded by flowers, surrounded by rocks, grid edge directly in front, make the paths of two jumpers intercept, another actor two cells in front.

*/

public class Jumper extends Actor {

    public Jumper() {
	setColor( Color.RED );
    }
    
    public Jumper( Color jumperColor ) {
	setColor( jumperColor );
    }

    public void act() {

	if (canJump())
	    jump();
	else
	    turn();
    }

    // turn jumper 45 degrees to right w/o changing location
    
    public void turn() {
	setDirection( getDirection() + Location.HALF_RIGHT );
    }

    // move jumper forward two space, jumping over flowers, rocks & other actors
    public void jump() {
	Grid<Actor> gr = getGrid();
	if (gr == null) 
	    return;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	next = next.getAdjacentLocation( getDirection() );
	if (gr.isValid(next))
	    moveTo(next);
	else
	    removeSelfFromGrid();
    }


    // test whether the jumper can move forward
    public boolean canJump() {
	Grid<Actor> gr = getGrid();
	if (gr == null)
	    return false;
	Location loc = getLocation();
	Location next = loc.getAdjacentLocation(getDirection());
	next = next.getAdjacentLocation( getDirection() );
	if (!gr.isValid(next))
	    return false;
	Actor neighbor = gr.get( next );
	return (neighbor == null) || (neighbor instanceof Flower);
    }
}
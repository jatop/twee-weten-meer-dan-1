package ingame;

public class MovementCard {
	String direction;
	int movement;
	int prio;

	public MovementCard(String direction, int movement, int prio) {
		this.direction = direction;
		this.movement = movement;
		this.prio = prio;
	}

	public String getRichting() {
		return direction;
	}

	public int getMovement() {
		return movement;
	}

	public int getPrio() {
		return prio;
	}

	@Override
	public String toString() {
		return "MovementCard [direction=" + direction + ", movement="
				+ movement + ", prio=" + prio + "]";
	}

}

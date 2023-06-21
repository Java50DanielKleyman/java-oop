package telran.exceptions;

//from which floor ball starts to broke
public class BallBrokenFloor {
	private int floor;

	public int getfloor() { // for test only
		return floor;
	}

	public void broken(int floor) throws Exception {
		if (floor >= this.floor) {
			throw new Exception();
		}
	}

	public BallBrokenFloor(int nFloors) {

		floor = (int) (1 + Math.random() * nFloors); // random number in the range [1, nFloors]
	}
}
//use binary search
import java.util.ArrayList;

public class Disk {
	int width, lastSlotID;
	ArrayList<Disk> lastPos;
		
	Disk(int width, ArrayList<Disk> lastPos) {
		this.lastPos = lastPos;
		this.width = width;
	}
		
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	public ArrayList<Disk> getLastPos() {
		return lastPos;
	}

	public void setLastPos(ArrayList<Disk> lastPos) {
		this.lastPos = lastPos;
	}
}

public class Disk {
	int width, value, lastSlotID;

	
	Disk(int width, int value, int lastSlotID){
		this.width = width;
		this.value = value;
		this.lastSlotID = lastSlotID;
	}
	
	void set(int width, int value, int lastSlotID){
		this.width = width;
		this.value = value;
		this.lastSlotID = lastSlotID;
	}
}

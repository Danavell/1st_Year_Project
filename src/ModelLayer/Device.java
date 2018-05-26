package ModelLayer;

public class Device {
	
	private String name;
	private String brand;
	private int serial;
	private int localid;
	
	public Device()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public int getLocalid() {
		return localid;
	}

	public void setLocalid(int localid) {
		this.localid = localid;
	}

	
}

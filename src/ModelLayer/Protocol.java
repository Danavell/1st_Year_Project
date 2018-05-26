package ModelLayer;

public class Protocol {

	private String date;
	private String techData;
	private Technician technician;
	private String material;
	private String descriptionOfTechnician;
	
	public Protocol()
	{
		
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTechData() {
		return techData;
	}

	public void setTechData(String techData) {
		this.techData = techData;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getDescriptionOfTechnician() {
		return descriptionOfTechnician;
	}

	public void setDescriptionOfTechnician(String descriptionOfTechnician) {
		this.descriptionOfTechnician = descriptionOfTechnician;
	}

	public Technician getTechnician() {
		return technician;
	}

	public void setTechnician(Technician technician) {
		this.technician = technician;
	}
	
	
	
}

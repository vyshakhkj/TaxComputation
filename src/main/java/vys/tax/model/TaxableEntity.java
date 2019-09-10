package vys.tax.model;

public class TaxableEntity {
	
	public int id;
	
	public String name;
	
	public int age;
	
	public String sex;
	
	public String location;
	
	public TaxParamVO taxParams;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public TaxParamVO getTaxParams() {
		return taxParams;
	}

	public void setTaxParams(TaxParamVO taxParams) {
		this.taxParams = taxParams;
	}
	
	
}

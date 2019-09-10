package vys.tax.model;

public class TaxDTO {
	
	public int id;
	
	public TaxParamVO taxParams;

	public TaxDTO(int id, TaxParamVO taxParams) {
		super();
		this.id = id;
		this.taxParams = taxParams;
	}
	
	

}

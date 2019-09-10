package vys.tax.model;

public class TaxParamVO {
	
	public double Basic;
	
	public double DA;
	
	public double HRA;
	
	public double Allowance;
	
	public double Deductions;
	
	public double Cess;
	
	public double TaxLiability;
	
	public boolean Computed;

	public double getBasic() {
		return Basic;
	}

	public void setBasic(double basic) {
		Basic = basic;
	}

	public double getDA() {
		return DA;
	}

	public void setDA(double dA) {
		DA = dA;
	}

	public double getHRA() {
		return HRA;
	}

	public void setHRA(double hRA) {
		HRA = hRA;
	}

	public double getAllowance() {
		return Allowance;
	}

	public void setAllowance(double allowance) {
		Allowance = allowance;
	}

	public double getDeductions() {
		return Deductions;
	}

	public void setDeductions(double deductions) {
		Deductions = deductions;
	}

	public double getCess() {
		return Cess;
	}

	public void setCess(double cess) {
		Cess = cess;
	}

	public double getTaxLiability() {
		return TaxLiability;
	}

	public void setTaxLiability(double taxLiability) {
		TaxLiability = taxLiability;
	}

	public boolean isComputed() {
		return Computed;
	}

	public void setComputed(boolean computed) {
		Computed = computed;
	}
	
	
}

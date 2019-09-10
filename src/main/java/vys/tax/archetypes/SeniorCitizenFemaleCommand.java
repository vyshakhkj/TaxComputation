package vys.tax.archetypes;

import vys.tax.computation.BaseComputationCommand;
import vys.tax.computation.COMPUTATION_CONTEXT;
import vys.tax.model.TaxDTO;

public class SeniorCitizenFemaleCommand extends BaseComputationCommand {
    @Override
    public boolean Execute(COMPUTATION_CONTEXT ctx) {
        TaxDTO td = (TaxDTO) ctx.get("tax_cargo");
        Double total = td.taxParams.getBasic() + td.taxParams.getDA() + td.taxParams.getAllowance()
                + td.taxParams.getHRA();
        Double net = total - td.taxParams.getDeductions() - td.taxParams.getCess();
        td.taxParams.TaxLiability = net * 0.05;
        td.taxParams.Computed = true;
        return true;
    }
}

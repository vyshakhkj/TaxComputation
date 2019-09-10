package vys.tax.archetypes;

import vys.tax.computation.BaseComputationCommand;
import vys.tax.computation.COMPUTATION_CONTEXT;
import vys.tax.model.TaxDTO;

public class OrdinaryCitizenCommand extends BaseComputationCommand {

        @Override public boolean Execute(COMPUTATION_CONTEXT ctx) {
                TaxDTO td = (TaxDTO) ctx.get("tax_cargo");
                td.taxParams.TaxLiability = 1500;
                td.taxParams.Computed = true;
                return true;
        }

}

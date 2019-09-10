package vys.tax.facade;

import vys.tax.computation.COMPUTATION_CONTEXT;
import vys.tax.computation.CommandDispatcher;
import vys.tax.model.TaxDTO;
import vys.tax.model.TaxableEntity;

/**
 * Created by A-5949 on 20-07-2019.
 */
public class TaxComputationFacade {

        private static String computeArchetype(TaxableEntity te) {
                if (te.getAge() > 60 && te.getSex().equalsIgnoreCase("F")) {
                        return "SeniorCitizenFemale";
                } else if (te.getAge() > 60) {
                        return "SeniorCitizen";
                } else if (te.getAge() > 18) {
                        return "OrdinaryCitizen";
                }
                return null;
        }

        public static boolean compute(TaxableEntity te) {
                String archetype = computeArchetype(te);
                COMPUTATION_CONTEXT ctx = new COMPUTATION_CONTEXT();
                TaxDTO td = new TaxDTO(te.getId(), te.getTaxParams());
                ctx.put("tax_cargo", td);
                boolean result = false;
                try {
                        result = CommandDispatcher.Dispatch(archetype, ctx);
                } catch (Exception e) {
                        System.out.println("Exception occured");
                }
                return result;
        }
}

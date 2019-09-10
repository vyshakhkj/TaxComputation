package vys.tax.computation;

/**
 * Created by A-5949 on 20-07-2019.
 */
public class BaseComputationCommand implements ComputationCommand {

        @Override
        public boolean preExecute(COMPUTATION_CONTEXT ctx) {
                return true;
        }

        @Override
        public boolean Execute(COMPUTATION_CONTEXT ctx) {
                return true;
        }

        @Override
        public boolean postExecute(COMPUTATION_CONTEXT ctx) {
                return true;
        }
}

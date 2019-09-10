package vys.tax.computation;

import java.io.IOException;

public class CommandDispatcher {

        private static ObjectFactory obj = new ObjectFactory("Pluggins.xml");

        public static boolean Dispatch(String archetype, COMPUTATION_CONTEXT ctx)
                throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
                ComputationCommand cmd = obj.get(archetype, "prototype");
                boolean result = false;
                if (cmd == null) {
                        return result;
                }
                if (cmd.preExecute(ctx)) {
                        result = cmd.Execute(ctx);
                        cmd.postExecute(ctx);
                }
                return result;
        }
}

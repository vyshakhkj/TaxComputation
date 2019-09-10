package vys.tax.computation;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public interface ComputationCommand {

        boolean preExecute(COMPUTATION_CONTEXT ctx);

        boolean Execute(COMPUTATION_CONTEXT ctx);

        boolean postExecute(COMPUTATION_CONTEXT ctx);

        static <T> T deepClone(T a) throws IOException, ClassNotFoundException {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(bos);
                out.writeObject(a);

                ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
                ObjectInputStream in = new ObjectInputStream(bis);
                T copied = (T) in.readObject();
                return copied;
        }
}

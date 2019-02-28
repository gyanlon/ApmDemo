package agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * xxx
 */
public class Transformer implements ClassFileTransformer {

    public byte[] transform(ClassLoader l, String className, Class<?> c,
                            ProtectionDomain pd, byte[] b) throws IllegalClassFormatException {

        System.out.println("enter tranform...");
        System.out.println(className);

        if (className.equals("demo/NormalClass")) {
            System.out.println("DOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        }

        System.out.println("exit");
        return b;
    }
}
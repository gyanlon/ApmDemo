package com.oyo.apm.javaagent;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Callable;

public class ZuulServletFilterInterceptor {

    @RuntimeType
    public static Object intercept(@SuperCall Callable<?> zuper, @AllArguments Object... args) throws Exception {
        System.out.println("intercept：拦截了");


        if (args.length >= 1 && args[0] instanceof HttpServletRequest) {
            HttpServletRequest req = (HttpServletRequest) args[0];
            System.out.println(req.getRequestURL());
        }

        Object call = zuper.call();

        if (args.length >= 2 && args[1] instanceof HttpServletResponse) {
            HttpServletResponse res = (HttpServletResponse) args[1];
            System.out.println(res.getStatus());

        }

        return call;
    }

}
package com.dachui.quickstart.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTests {

    @Test
    public void proxyTest() {
        SecurityHandler proxy = new SecurityHandler();
        UserService service = (UserService) proxy.newProxyObject(new UserServiceImpl());
        String name=service.getUserName(1);
        System.out.println(name);

        System.out.println("--------------------------------------------");

    }


    class SecurityHandler implements InvocationHandler {

        private Object targetObject;

        public Object newProxyObject(Object targetObject){
            this.targetObject = targetObject;
            Object object = Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                    targetObject.getClass().getInterfaces(), this);
            return object;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            try{
                security( args);
                result = method.invoke(this.targetObject, args);
            }catch(Exception e){
                e.printStackTrace();
            }
            return result;
        }

        private void security(Object[] args){
            System.out.println("------------security()--------------");
            System.out.println(args);
        }
    }

}

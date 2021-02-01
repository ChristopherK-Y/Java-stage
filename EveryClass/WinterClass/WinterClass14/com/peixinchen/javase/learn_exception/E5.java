package com.peixinchen.javase.learn_exception;

// MyException 是 Exception 的子类 && 不是 RuntimeException 的子类
// MyException 对象是 checked exception
class MyException extends Exception {
}

// YourException 是 unchecked exception
class YourException extends RuntimeException {
}

public class E5 {
    // throw 是抛出异常
    // throws 是用在方法上，声明方法可能抛出哪些异常

    private static void method2() throws MyException {
        try {
            throw new MyException();
        } catch (NullPointerException e) {
            throw e;    // 通过引用抛出异常对象即可
        }
    }

    private static void method1() throws YourException {
        throw new YourException();
    }
}

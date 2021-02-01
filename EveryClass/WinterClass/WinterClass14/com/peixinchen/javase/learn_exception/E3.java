package com.peixinchen.javase.learn_exception;

public class E3 {
    public static void main(String[] args) {
        try {
            int[] a = {};   // a.length == 0   [0, 0)
            a[0] = 18;      // ArrayIndexOutOfBoundsException
            System.out.println("1");
        } catch (NullPointerException e) {
            System.out.println("2");
        } catch (RuntimeException e) {
            System.out.println("3");
        } catch (Exception e) {
            System.out.println("4");
        } catch (Throwable e) {
            System.out.println("5");
        } finally {
            System.out.println("6");
        }
    }
}

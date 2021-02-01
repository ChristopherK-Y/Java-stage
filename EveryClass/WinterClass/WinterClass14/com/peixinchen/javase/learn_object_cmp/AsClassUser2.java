package com.peixinchen.javase.learn_object_cmp;

import java.util.Random;
import java.util.Scanner;

public class AsClassUser2 {
    public static void main(String[] args) {
        // Random/Scanner/String
        // class Random implements java.io.Serializable
        // Random 不具备 "<、==、>" 的比较能力

        // public final class Scanner implements Iterator<String>, Closeable
        // Scanner 不具备 "<、==、>" 的比较能力

        // public final class String
        //    implements java.io.Serializable, Comparable<String>, CharSequence
        // String 具备 "<、==、>" 的比较能力

        String s = "hello";
        String t = "world";

        int r = s.compareTo(t);
        if (r < 0) {
            System.out.println("s < t");
        } else if (r == 0) {
            System.out.println("s == t");
        } else {
            System.out.println("s > t");
        }
    }
}

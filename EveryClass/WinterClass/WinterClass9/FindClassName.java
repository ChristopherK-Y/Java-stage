import java.util.Arrays;

public class FindClassName {
    public static void main1(String[] args) {
        String url = "https://docs.oracle.com/javase/8/docs/api/java/lang/String.html";
        String[] split = url.split("/");
        String[] ans = split[split.length - 1].split("\\.");//类名
        System.out.println(split[split.length - 3] + "/" + split[split.length - 2] + "/" + ans[0]);//包及类名
    }

    public static void main2(String[] args) {
        String classNameWithPackage = "java.util.Scanner";
        System.out.println(getUrl(classNameWithPackage));

    }

    public static String getUrl(String classNameWithPackage) {
        return String.format("https://docs.oracle.com/javase/8/docs/api/%s.html", classNameWithPackage.replace(".", "/"));
    }

    public static void main3(String[] args) {
        String s = "package com.peixinchen.javase.learn_string;\n" +
                "\n" +
                "import java.util.Arrays;\n" +
                "import java.util.Scanner;\n" +
                "\n" +
                "public class HelloWorld {\n" +
                "    public static void main(String[] args) {\n" +
                "        long[] array = new long[5];\n" +
                "        Scanner s = new Scanner(System.in);\n" +
                "        for (int i = 0; i < 5; i++) {\n" +
                "            array[i] = s.nextLong();\n" +
                "        }\n" +
                "        System.out.println(Arrays.toString(array));\n" +
                "    }\n" +
                "}";

        // 这份源码属于哪个包？  com.peixinchen.javase.learn_string
        // 这份源码导入了哪些类？
        // java.uti.Arrays
        // java.util.Scanner
        // 这份源码定义的类名是什么？
        // HelloWorld
        parse(s);
    }

    public static void parse(String java) {
        if (!java.startsWith("package")) {
            System.out.println("No Package");
        }
        String[] lines = java.split("\n");
        System.out.println("package:" + lines[0].substring(8, lines[0].length() - 1));

        boolean hasImport = false;
        for (String everyLines : lines) {
            if (everyLines.startsWith("import")) {
                System.out.println("import:" + everyLines.substring(7, everyLines.length() - 1));
                hasImport = true;
            }
        }
        if (!hasImport) {
            System.out.println("No Import");
        }
        boolean hasClass = false;
        for (String everyLines : lines) {
            if (everyLines.startsWith("public class")) {
                System.out.println("class:" + everyLines.substring(13, everyLines.length() - 1));
                hasClass = true;
            }
        }
        if(!hasClass){
            System.out.println("No Class");
        }
    }

    public static void main(String[] args){
        String theString = "123";
        System.out.println(theString.concat("45678"));
    }
}

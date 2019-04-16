package test;

import java.util.HashSet;
import java.util.Set;

public class 买 {
    public static void main(String[] args) {
        Set<String> strings = new HashSet<String>();
        String a =  new String("aa");
        String c =  new String("aa");
        String b = "aa";
        strings.add(a);
        strings.add(c);
        System.out.println(a==c);
        System.out.println(strings.size());
    }
}

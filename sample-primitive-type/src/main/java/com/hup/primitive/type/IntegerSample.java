package com.hup.primitive.type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class IntegerSample {


    public static void main(String[] args) {
        //t//est();
//        Long gcd = Gcd(8L, 19L);
//        System.out.println(gcd);
        int lcm = getLCM(20, 18);
        System.out.println(lcm);
    }

    public static void integerSample() {
        Integer a = 10;
        int b = 10;
        if (a == b) {
            System.out.println(a);
        }
    }

    public static void transfer(String input) {
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(input.split(" ")));
        List<String> collect = strings.stream().filter(s -> !Objects.equals("", s)).collect(Collectors.toList());
        List<String> demo = new ArrayList<>();
        collect.forEach(c -> {
            demo.add(c.toLowerCase());
        });
        System.out.println(String.join(" ", demo));
    }

    public static Long Gcd(Long a, Long b) {
        if (a <= 0 || b <= 0)
            return -1L;
        else if (a > b)
            return Gcd(a - b, b);
        else if (a < b)
            return Gcd(a, b - a);
        else
            return a;
    }

    public static void test() {
        Long m = 10L;

        Long n = 3L;
        System.out.println(m % n);
        System.out.println(m / n);
    }


    public static int getLCM(int m, int n) {
        int mn = m * n;
        int abs = Math.abs(m);
        double sqrt = Math.sqrt(9);
        return mn / getGCD(m, n);
    }

    public static int getGCD(int m, int n) {
        if (n == 0) {
            return m;
        }
        int gcd = m % n;
        return getGCD(n, gcd);
    }

}

package com.hup.primitive.type;

import java.util.*;
import java.util.stream.Collectors;

public class CommonMultipleSample {

    public static void main(String[] args) {
        int[] integers = new int[]{5, 1, 7, 3};
        findNGE(integers, integers.length);
        //joint("i aM aNd   witH");
    }

    private static boolean isPrime(int data) {
        for (int i = 2; i <= Math.sqrt(Math.abs(data)); i++) {
            if (data % i == 0)
                return false;
        }
        return true;
    }

    //求list中的最大值
    private static Integer getListMax(List<Integer> data) {
        return data.parallelStream().max(((o1, o2) -> o1.compareTo(o2))).get();
    }

    private static void getLCM(List<Integer> datas, Integer max) {
        for (int i = max; i <= Integer.MAX_VALUE; i++) {
            boolean b = true;    //设置标记
            for (int j = 0; j < datas.size(); j++) {
                if (max % datas.get(j) != 0) {
                    b = false;  //只要有一个数不能整除max则令标记为false
                }
            }
            max++;
            if (b) {    //如果标记为true说明该max可以整除这n个数
                //则max为最小公倍数
                System.out.println(i);
                break;    //跳出循环
            }
        }
    }

    private static void getSort(List<Integer> datas) {
        datas.sort((o1, o2) -> o1.compareTo(o2));
        System.out.println(datas.get(datas.size() - 1));
    }


    public static int getLCM(int m, int n) {
        int mn = m * n;
        return mn / getGCD(m, n);
    }

    public static int getGCD(int m, int n) {
        if (n == 0) {
            return m;
        }
        int gcd = m % n;
        return getGCD(n, gcd);
    }

    private static void joint(String target) {
        String[] split = target.split(" ");
        ArrayList<String> strings = new ArrayList<>(Arrays.asList(split));
        List<String> collect = strings.stream().filter(s -> !(Objects.equals(s, ""))).collect(Collectors.toList());
        ArrayList<String> targetLists = new ArrayList<String>();
        collect.stream().forEach(c -> {
            String temp = c.toUpperCase().charAt(0) + c.substring(1).toLowerCase();
            targetLists.add(temp);
        });
        System.out.println(String.join(" ", targetLists));
    }


    public static void findNGE(int[] arr, int len) {
//初始化栈
        Stack<Integer> stack = new Stack<Integer>();
//将数组首个元素入栈
        stack.push(arr[0]);
        int top, next;  //定义两个指针变量
        for (int i = 1; i < arr.length; i++) {
            next = arr[i];
            top = stack.peek();

//判断是否找到栈顶元素的NGE,此处是循环判断栈中元素与当前元素next值得比较，输出不会按照原数组顺序
            while ((!stack.isEmpty()) && top < next) {
                System.out.printf("%d --> %d", top, next);
                System.out.println();
                stack.pop(); //出栈

//继续判断栈顶
                if (!stack.isEmpty()) {
                    top = stack.peek();
                }
            }
//将下一个元素入栈
            stack.push(next);
        }
        while (!stack.isEmpty()) {
            top = stack.peek();
            stack.pop();
            System.out.printf("%d --> %d", top, -1);
            System.out.println();
        }
    }


}

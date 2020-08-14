package com.hjx.system.test;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    //定义用于测试的HashMap
    private static final HashMap<Integer, Integer> hashMap = new HashMap<>();

    private static final  ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap();
    //定义用于测试的Hashtable
    private static final Hashtable<Integer, Integer> hashtable = new Hashtable<>();
    //定义用于测试的TreeMap
    private static final TreeMap<Integer, Integer> treeMap = new TreeMap<>();

    /**
     * 添加
     *
     * @param map
     * @param number
     */
    private static void addMap(Map<Integer, Integer> map, int number) {
        long startTime = System.currentTimeMillis();

        if (number <= 0) {
            return;
        }

        for (int i = 0; i <= number; i++) {
            map.put(i, i);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("添加(" + number + ")个元素使用时间:" + (endTime - startTime) + "ms");
    }

    /**
     * 获取元素的方法
     *
     * @param map
     * @param number
     */
    public static void getEntry(Map<Integer, Integer> map, int number) {
        Long startTime = System.currentTimeMillis();
        if (number <= 0) {
            return;
        }
        for (int i = 0; i < number; i++) {
            map.get(i);
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("获取(" + number + ")个元素使用时间:" + (endTime - startTime) + "ms");
    }

    public static void main(String[] args) {


        System.out.println("-------HashMap测试开始-----");
        addMap(hashMap, 10000000);
        getEntry(hashMap, 10000000);
        System.out.println("-------HashMap测试结束-----");

        System.out.println("-------Hashtable测试开始-----");
        addMap(hashtable, 10000000);
        getEntry(hashtable, 10000000);
        System.out.println("-------Hashtable测试结束-----");

        System.out.println("-------TreeMap测试开始-----");
        addMap(treeMap, 10000000);
        getEntry(treeMap, 10000000);
        System.out.println("-------TreeMap测试结束-----");

        System.out.println("-------concurrentHashMap测试开始-----");
        addMap(concurrentHashMap, 10000000);
        getEntry(concurrentHashMap, 10000000);
        System.out.println("-------concurrentHashMap测试开始-----");

        hashMap.clear();
        hashtable.clear();
        treeMap.clear();
        concurrentHashMap.clear();
    }


}

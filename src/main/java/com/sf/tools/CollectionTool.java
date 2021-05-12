package com.sf.tools;

import java.util.*;

/**
 * @author :JSF
 * @desc :数组集合工具类
 */
public class CollectionTool {

    /**
     * <li> 集合是否为空</li>
     * @param collection 集合
     * @return boolean
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * <li> 集合是否非空</li>
     * @param coll 集合
     * @return boolean
     */
    public static boolean isNotEmpty(Collection<?> coll){
        return !isEmpty(coll);
    }

    /**
     * <li> Map是否为空</li>
     * @param map map集合
     * @return boolean
     */
    public static boolean isEmpty(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    /**
     * <li> 转换任意数量的对象为list</li>
     * @param ts 可变对象数组
     * @param <T> 对象泛型
     * @return List<T>
     */
    public static <T> List<T> toList(T... ts){
        if(ts == null || ts.length == 0){
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>();
        for (T t : ts) {
            result.add(t);
        }
        return result;
    }

    /**
     * <li> 转换任意数量的对象为set</li>
     * @param ts 可变对象数组
     * @param <T> 对象泛型
     * @return Set<T>
     */
    public static <T> Set<T> toSet(T... ts){
        if(ts == null || ts.length == 0){
            return new HashSet<>();
        }
        Set<T> result = new HashSet<>();
        for (T t : ts) {
            result.add(t);
        }
        return result;
    }

    /**
     * <li> 将数组转换为list</li>
     * @param ts 可变对象数组
     * @param <T> 对象泛型
     * @return List<T>
     */
    public static <T> List<T> arrayToList(T[] ts){
        if(ts == null || ts.length == 0){
            return new ArrayList<>();
        }
        List<T> result = new ArrayList<>();
        for (T t : ts) {
//            if(t.getClass() == String.class){
//                if(StringTools.isBlank((String) t)){
//                    continue;
//                }
//            }
            result.add(t);
        }
        return result;
    }

    /**
     * <li> list添加并去重</li>
     * @param source 源list
     * @param addList 添加的list
     * @param <T> 对象泛型
     */
    public static <T> void addAllDeduplication(List<T> source,List<T> addList){
        addList.forEach(t ->  {
            if(source.contains(t)){
                return;
            }
            source.add(t);
        });
    }

    /**
     * <li> 将set转换为list</li>
     * @param source 源set
     * @param <T> 对象泛型
     * @return List
     */
    public static <T> List<T> setToList(Set<T> source){
        List<T> result = new ArrayList<>();
        if(source == null){
            return result;
        }
        source.forEach(s->{
            result.add(s);
        });
        return result;
    }

    /**
     * <li> 将list转换为set</li>
     * @param source 源list
     * @param <T> 对象泛型
     * @return Set<T>
     */
    public static <T> Set<T> listToSet(List<T> source){
        Set<T> result = new HashSet<>();
        if(source == null){
            return result;
        }
        source.forEach(s->{
            result.add(s);
        });
        return result;
    }

}

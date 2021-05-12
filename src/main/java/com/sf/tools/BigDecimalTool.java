package com.sf.tools;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author :JSF
 * @date :2020/6/5 12:50
 * @desc :BigDecimal工具类
 */
public class BigDecimalTool {

    public static final int MONEY_POINT = 2; // 货币保留两位小数

    /**
     * <li> 根据模式保留小数</li>
     * @param value 值
     * @param point 小数位
     * @param mode 模式
     * @return Double
     */
    public static Double keepDecimals(double value,int point,RoundingMode mode){
        NumberFormat nf = NumberFormat.getInstance();
        nf.setRoundingMode(mode);//设置模式
        nf.setMinimumFractionDigits(point);//设置最小保留几位小数
        nf.setMaximumFractionDigits(point);//设置最大保留几位小数
        return Double.valueOf(nf.format(value));
    }
    /**
     * <li> 保留小数并四舍五入</li>
     * @param value 值
     * @param point 小数位数
     * @return Double
     */
    public static Double keepDecimalsAndRoundUp(double value, int point) {
        return keepDecimals(value,point,RoundingMode.HALF_UP);//设置四舍五入
    }

    /**
     * <li> 保留小数直接截取</li>
     * @param value 值
     * @param point 小数位数
     * @return Double
     */
    public static Double keepDecimalsAndFloor(double value, int point) {
        return keepDecimals(value,point,RoundingMode.FLOOR);//设置截取
    }

    /**
     * <li> 数字插入千位符</li>
     * @param value 值
     * @return String
     */
    public static String insertThousands(Double value) {
        DecimalFormat format = new DecimalFormat();
        format.setGroupingSize(3);
        return format.format(value.doubleValue());
    }

    /**
     * <li> 数字插入千位符 并四舍五入保留小数</li>
     * @param value 值
     * @param point 小数位
     * @return String
     */
    public static String insertThousandsAndRounding(Double value,int point) {
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(point);
        format.setGroupingSize(3);
        format.setRoundingMode(RoundingMode.HALF_UP);
        return format.format(value.doubleValue());
    }

    /**
     * <li> 数字插入千位符 并截取保留小数</li>
     * @param value 值
     * @param point 小数位
     * @return String
     */
    public static String insertThousandsAndIntercept(Double value,int point) {
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(point);
        format.setGroupingSize(3);
        format.setRoundingMode(RoundingMode.FLOOR);
        return format.format(value.doubleValue());
    }


    /**
     * <li> 两个double数字相加</li>
     * @param valueOne 值1
     * @param valueTwo 值2
     * @return double
     */
    public static Double add(double valueOne, double valueTwo) {
        BigDecimal n1 = new BigDecimal(Double.toString(valueOne));
        BigDecimal n2 = new BigDecimal(Double.toString(valueTwo));
        return n1.add(n2).doubleValue();
    }

    /**
     * <li> 两个BigDecimal数字相加</li>
     * @param valueOne 值1
     * @param valueTwo 值2
     * @return BigDecimal
     */
    public static BigDecimal add(BigDecimal valueOne, BigDecimal valueTwo) {
        return valueOne.add(valueTwo);
    }

    /**
     * <li> 两个double数字相减</li>
     * @param valueOne 值1
     * @param valueTwo 值2
     * @return BigDecimal
     */
    public static BigDecimal subtract(double valueOne, double valueTwo) {
        BigDecimal n1 = new BigDecimal(Double.toString(valueOne));
        BigDecimal n2 = new BigDecimal(Double.toString(valueTwo));
        return subtract(n1,n2);
    }

    /**
     * <li> 两个BigDecimal数字相减</li>
     * @param valueOne 值1
     * @param valueTwo 值2
     * @return BigDecimal
     */
    public static BigDecimal subtract(BigDecimal valueOne,BigDecimal valueTwo){
        return valueOne.subtract(valueTwo);
    }

    /**
     * <li> 两个double数字相乘</li>
     * @param v1
     * @param v2
     * @return BigDecimal
     */
    public static BigDecimal multiply(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return multiply(n1,n2);
    }

    /**
     * <li> 两个BigDecimal数字相乘 </li>
     * @param v1 值1
     * @param v2 值2
     * @return BigDecimal
     */
    public static BigDecimal multiply(BigDecimal v1,BigDecimal v2){
        return v1.multiply(v2);
    }

    /**
     * <li>两个BigDecimal数字相乘</li>
     * @param v1 值1
     * @param v2 值2
     * @return BigDecimal
     */
    public static BigDecimal multiply(BigDecimal v1,Integer v2){
        return v1.multiply(new BigDecimal(String.valueOf(v2)));
    }

    /**
     * <li> 两个double数字相除</li>
     * @param v1 值1
     * @param v2 值2
     * @return double
     */
    public static Double divide(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return n1.divide(n2, 10, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * <li>两个BigDecimal数字相除</li>
     * @param v1 值1
     * @param v2 值2
     * @return BigDecimal
     */
    public static BigDecimal divide(BigDecimal v1, BigDecimal v2) {
        return v1.divide(v2, 10, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * <li> 两个double比较大小</li>
     * <li> 大于 -> 1, 等于 -> 0, 小于 -> -1</li>
     * @param v1 值1
     * @param v2 值2
     * @return int
     */
    public static int compare(double v1, double v2) {
        BigDecimal n1 = new BigDecimal(Double.toString(v1));
        BigDecimal n2 = new BigDecimal(Double.toString(v2));
        return compare(n1,n2);
    }

    /**
     * <li> 两个BigDecimal数字比较大小</li>
     * <li> 大于 -> 1, 等于 -> 0, 小于 -> -1</li>
     * @param v1 值1
     * @param v2 值2
     * @return int
     */
    public static int compare(BigDecimal v1,BigDecimal v2){
        return v1.compareTo(v2);
    }

}

package com.sf.tools;

/**
 * @author :JSF
 * @date :2020/5/11 17:26
 * @desc :正则工具类
 */
public class RegularTool {

    /**
     * 手机号正则
     */
    private static final String PHONE = "^1(3|4|5|6|7|8|9)\\d{9}$";
    /**
     * 邮箱正则
     */
    private static final String EMAIL = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
    /**
     * 数字正则
     */
    private static final String NUMBER = "^-?[0-9]+.?[0-9]*$";
    /**
     * 18位身份证正则
     */
    private static final String ID_CARD_18 = "^([1-6][1-9]|50)\\d{4}(18|19|20)\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$";
    /**
     * 15位身份证正则
     */
    private static final String ID_CARD_15 = "^([1-6][1-9]|50)\\d{4}\\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\\d{3}$";
    private static final String janPattern = "(0?[13578]|1[02])-(0?[1-9]|[12][0-9]|3[01])";
    private static final String febPattern = "0?2-(0?[1-9]|[12][0-9])";
    private static final String aprPattern = "(0?[469]|11)-(0?[1-9]|[12][0-9]|30)";
    /**
     * 日期正则 yyyy-MM-dd
     */
    private static final String DATE_PATTERN = String.format("^2[0-9]{3}-(%s|%s|%s)$", janPattern, febPattern, aprPattern);
    /**
     * 日期+时间正则 yyyy-MM-dd HH:mm:ss
     */
    private static final String DATE_TIME_PATTERN = String.format("^2[0-9]{3}-(%s|%s|%s) ([01][0-9]|2[0-3])(:[0-5][0-9]){2}$", febPattern, janPattern, aprPattern);


    /**
     * <li> 手机号码正则匹配</li>
     * @param phone 手机号
     * @return boolean
     */
    public static boolean matchPhone(String phone){
        if(phone == null){
            return false;
        }
        return phone.matches(PHONE);
    }

    /**
     * <li> 邮箱号码正则匹配</li>
     * @param email 邮箱号码
     * @return boolean
     */
    public static boolean matchEmail(String email){
        if(email == null){
            return false;
        }
        return email.matches(EMAIL);
    }

    /**
     * <li> 日期正则匹配</li>
     * <li> 格式 yyyy-MM-dd</li>
     * @param date 日期字符串
     * @return boolean
     */
    public static boolean matchDate(String date){
        if(date == null){
            return false;
        }
        return date.matches(DATE_PATTERN);
    }

    /**
     * <li> 日期+时间正则匹配</li>
     * <li> 格式：yyyy-MM-dd HH:mm:ss</li>
     * @param datetime 日期时间字符串
     * @return boolean
     */
    public static boolean matchDateTime(String datetime){
        if(datetime == null){
            return false;
        }
        return datetime.matches(DATE_TIME_PATTERN);
    }

    /**
     * <li> 数字正则匹配</li>
     * @param numberStr 数字字符串
     * @return boolean
     */
    public static boolean matchNumber(String numberStr){
        if(numberStr == null){
            return false;
        }
        return numberStr.matches(NUMBER);
    }

    /**
     * <li> 18位身份证号码正则匹配</li>
     * @param idCard 身份证号码
     * @return boolean
     */
    public static boolean match18IdCard(String idCard){
        if(idCard == null){
            return false;
        }
        return idCard.matches(ID_CARD_18);
    }

    /**
     * <li> 15位身份证号码正则匹配</li>
     * @param idCard 身份证号码
     * @return boolean
     */
    public static boolean match15IdCard(String idCard){
        if(idCard == null){
            return false;
        }
        return idCard.matches(ID_CARD_15);
    }


}

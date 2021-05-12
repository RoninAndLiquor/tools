package com.sf.tools;

/**
 * @author :JSF
 * @date :2021/5/11 18:33
 * @desc :
 */
public class StringTool {

    /**
     * <li> 是否为空（全为空格字符串也为空）</li>
     * @param cs 校验字符串
     * @return boolean
     */
    public static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    /**
     * <li> 是否有任意一个为空（全为空格字符串也为空）</li>
     * @param sequences 校验字符串数组
     * @return boolean
     */
    public static boolean isAnyBlank(CharSequence... sequences){
        if(sequences == null){
            return false;
        }
        for (CharSequence sequence : sequences) {
            if(isBlank(sequence)){
                return true;
            }
        }
        return false;
    }

    /**
     * <li>是否为空（空格字符不为空）</li>
     * @param cs 校验字符串
     * @return boolean
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * <li> 是否有任意一个为空（空格字符不为空）</li>
     * @param sequences 校验字符串数组
     * @return boolean
     */
    public static boolean isAnyEmpty(CharSequence... sequences){
        if(sequences == null){
            return false;
        }
        for (CharSequence sequence : sequences) {
            if(isEmpty(sequence)){
                return true;
            }
        }
        return false;
    }


}

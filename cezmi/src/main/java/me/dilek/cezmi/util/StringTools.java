package me.dilek.cezmi.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Hakan Dilek on 15.04.2015.
 */
public class StringTools {
    public static boolean isNotEmpty(String s) {
        return StringUtils.isNotEmpty(s);
    }

    public static boolean isValidString(String s) {
        return StringUtils.isNotEmpty(s);
    }

}

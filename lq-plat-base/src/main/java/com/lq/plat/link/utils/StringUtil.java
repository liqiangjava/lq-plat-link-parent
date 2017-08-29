package com.lq.plat.link.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class StringUtil {

    public static String getCDATAStr(String param)
    {
        Pattern reg = Pattern.compile("<!\\[CDATA\\[([\\d\\D]+)\\]\\]>");
        Matcher m = reg.matcher(param);
        String str = param;
        if (m.matches()) {
            str = m.group(1);
        }
        return str;
    }

    public static String camelTounderline(String param)
    {
        Pattern p = Pattern.compile("[A-Z]");
        if (StringUtils.isBlank(param)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find())
        {
            builder.replace(mc.start() + i, mc.end() + i, "_" + mc.group().toLowerCase());
            i++;
        }
        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    public static String underlineTocamel(String param)
    {
        Pattern p = Pattern.compile("[_]");
        if (StringUtils.isBlank(param)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find())
        {
            int start = mc.start();
            int end = mc.end();
            String str = builder.substring(start + 1 + i, end + 1 + i).toUpperCase();
            builder.replace(start + i, end + 1 + i, str);
            i--;
        }
        if ('_' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    public static String char2Tocamel(String param)
    {
        Pattern p = Pattern.compile("[2]");
        if (StringUtils.isBlank(param)) {
            return "";
        }
        StringBuilder builder = new StringBuilder(param);
        Matcher mc = p.matcher(param);
        int i = 0;
        while (mc.find())
        {
            int start = mc.start();
            int end = mc.end();
            String str = builder.substring(start + 1 + i, end + 1 + i).toUpperCase();
            builder.replace(start + i + 1, end + 1 + i, str);
            i--;
        }
        if ('2' == builder.charAt(0)) {
            builder.deleteCharAt(0);
        }
        return builder.toString();
    }

    public static String firstToLower(String input)
    {
        return input.substring(0, 1).toLowerCase() + input.substring(1);
    }

    public static String firstToUpperCase(String input)
    {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String[] split(String str)
    {
        return split(str, null);
    }

    public static String[] split(String str, String separator)
    {
        if (separator == null) {
            separator = ",";
        }
        return StringUtils.splitByWholeSeparator(str, separator);
    }

    public static String[] splitCharNumbers(String str)
    {
        Pattern r = Pattern.compile("\\d+");
        Matcher m = r.matcher(str);
        String[] ret = { "", "" };
        if (m.find()) {
            ret[1] = m.group(0);
        }
        ret[0] = str.replace(ret[1], "");
        return ret;
    }

    public static String toSBC(String input)
    {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = ' ';
            } else if (c[i] < '') {
                c[i] = ((char)(c[i] + 65248));
            }
        }
        return new String(c);
    }

    public static String toDBC(String input)
    {
        char[] c = input.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                c[i] = ' ';
            } else if ((c[i] > 65280) && (c[i] < 65375)) {
                c[i] = ((char)(c[i] - 65248));
            }
        }
        String returnString = new String(c);
        return returnString;
    }

    public static String replaceBlank(String str)
    {
        String dest = "";
        if (str != null)
        {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    public static String getUTF8FromISO8859(String str)
    {
        if (str == null) {
            return str;
        }
        try
        {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return str;
    }

    public static String unicode2String(String unicode)
    {
        int len = unicode.length();
        StringBuilder outBuffer = new StringBuilder(len);
        for (int x = 0; x < len;)
        {
            char aChar = unicode.charAt(x++);
            if (aChar == '\\')
            {
                aChar = unicode.charAt(x++);
                if (aChar == 'u')
                {
                    int value = 0;
                    for (int i = 0; i < 4; i++)
                    {
                        aChar = unicode.charAt(x++);
                        switch (aChar)
                        {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - 48;
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 97;
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 65;
                                break;
                            case ':':
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                            case '?':
                            case '@':
                            case 'G':
                            case 'H':
                            case 'I':
                            case 'J':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'S':
                            case 'T':
                            case 'U':
                            case 'V':
                            case 'W':
                            case 'X':
                            case 'Y':
                            case 'Z':
                            case '[':
                            case '\\':
                            case ']':
                            case '^':
                            case '_':
                            case '`':
                            default:
                                throw new IllegalArgumentException("Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char)value);
                }
                else
                {
                    if (aChar == 't') {
                        aChar = '\t';
                    } else if (aChar == 'r') {
                        aChar = '\r';
                    } else if (aChar == 'n') {
                        aChar = '\n';
                    } else if (aChar == 'f') {
                        aChar = '\f';
                    }
                    outBuffer.append(aChar);
                }
            }
            else
            {
                outBuffer.append(aChar);
            }
        }
        return outBuffer.toString();
    }
}

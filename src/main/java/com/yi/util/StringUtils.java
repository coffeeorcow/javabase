package com.yi.util;

import java.util.*;

public class StringUtils {

    public static boolean isBlank(String str) {
        return Objects.isNull(str) || str.trim().isEmpty();
    }

    public static String format(String pattern, Object... args) {
        // todo: 参数式格式化字符串
        if (StringUtils.isBlank(pattern)) {
            return pattern;
        }

        String str1 = pattern.replaceAll("}", "");
        String[] strs = str1.split("\\{");
        List<String> words = Arrays.asList(strs);

        StringBuilder sb = new StringBuilder();
        int len = args.length;
        for (int i = 0; i < words.size(); i++) {
            sb.append(words.remove(i));
            if (i < len) {
                sb.append(args[i]);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        System.out.println(format("{}:{}-{}", 1, 2, "hi"));
        System.out.println(format("{}", 1));
    }
}

/*
 * Copyright (C) 2012 Baidu.com Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.baidu.lxy;

import java.util.ArrayList;
import java.util.Random;

/**
 * A String util class.
 * 
 * @author luxiaoyu01@baidu.com
 * @date 2012-11-21
 * @version
 * @todo
 */
public class Strings {
    public ArrayList<String> strings = null;

    public Strings(ArrayList<String> strings) {
        this.strings = strings;
    }

    public Strings grep(String str) {
        ArrayList<String> ret = new ArrayList<String>();
        for (String line : strings) {
            if (line.contains(str)) {
                ret.add(line);
            }
        }
        return new Strings(ret);
    }

    public Strings getRow(String regularExpression, int rowNumber)
            throws ArrayIndexOutOfBoundsException {
        ArrayList<String> ret = new ArrayList<String>();
        for (String line : strings) {
            String[] rows = line.trim().split(regularExpression);
            if (rows.length < rowNumber) {
                throw new ArrayIndexOutOfBoundsException(String.format(
                        "rows.length(%s) < rowNumber(%s) line:%s", rows.length, rowNumber, line));
            }
            ret.add(rows[rowNumber - 1]);
        }
        return new Strings(ret);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(1024);
        for (String line : strings) {
            sb.append(line).append('\n');
        }
        return sb.toString();
    }

    /**
     * e.g. transfer "767E" to "\u767E"
     * 
     * @param unicodeString
     * @return "" means failed
     */
    public static String unicodeStringToUnicode(String unicodeString) {
        try {
            char[] unicode = new char[unicodeString.length() / 4];
            for (int i = 0, j = 0; i < unicodeString.length(); i += 4, j++) {
                unicode[j] = (char) Integer.parseInt(unicodeString.substring(i, i + 4), 16);
            }
            return new String(unicode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    public static int getRStringId(String packageName, String stringName) {
        Class<?> stringClass = getRClass(packageName, "string");
        if (null == stringClass) {
            return -1;
        }
        try {
            return (Integer) stringClass.getDeclaredField(stringName)
                    .get(stringClass.newInstance());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * NOTICE: This method can not work at apk which is chaos.
     * 
     * @param packageName
     * @param className
     * @return
     */
    public static Class<?> getRClass(String packageName, String className) {
        try {
            Class<?>[] classes = Class.forName(packageName + ".R").getDeclaredClasses();
            for (int i = 0; i < classes.length; i++) {
                if (classes[i].getName().indexOf("$" + className) != -1) {
                    return classes[i];
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 使用indexOf分割字符串
     * 
     * 比String.split()快提高6倍；比StringTokenizer快50%
     * 
     * @param target target
     * @param token token
     * @return 分割后的数组
     */
    public static String[] splitViaIndexOf(String target, String token) {
        int fromIndex = 0;
        int index = 0;
        int size = target.length() / (token.length() + 1);
        ArrayList<String> strings = new ArrayList<String>(size);
        while ((index = target.indexOf(token, fromIndex)) != -1) {
            if (index > fromIndex) {
                strings.add(target.substring(fromIndex, index));
            }
            fromIndex = index + 1;
        }

        // 忽略fromIndex恰好是结尾的情况
        if (target.length() != fromIndex) {
            strings.add(target.substring(fromIndex, target.length()));
        }
        return strings.toArray(new String[strings.size()]);
    }
    
    private static final char[] CHAR_BASE = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                                  .toCharArray();

    /**
     * 生成指定长度的随机字符串，包含大小写字母和数字。
     * 
     * @param length 表示生成字符串的长度
     * @return 随机字符串
     */
    public static String generateRandomString(int length) {
        int bound = CHAR_BASE.length;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(CHAR_BASE[random.nextInt(bound)]);
        }
        return sb.toString();
    }
    
}

package com.baidu.chunlei.exercise.array;

import java.util.Arrays;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2012-4-9
 * @version
 * @todo
 */
public class ShallowClone {

    public static void main(String[] args) {
        Color[] src = new Color[3];
        src[0] = new Color(0);
        src[1] = new Color(1);
        src[2] = new Color(2);
        Color[] dst = Arrays.copyOf(src, src.length);
        dst[0].color = 9;

        for (Color i : src) {
            System.out.println(i.color);
        }
        for (Color i : dst) {
            System.out.println(i.color);
        }
    }

}
class Color {
    public int color;
    
    public Color(int color) {
        this.color = color;
    }
}

package com.baidu.chunlei.exercise;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-2-24
 * @version
 * @todo 
 */
public class Tricks {
    
    /**
     * @param args
     * @throws MalformedURLException 
     */
    public static void main(String[] args) throws MalformedURLException {
        List<Integer> numbers = new ArrayList<Integer>(){{ add(1); add(2); }};
        System.out.println(numbers.toString());
        
        Collections.<String,Integer>emptyMap();
        Collection<T> c = Collections.EMPTY_LIST;
        
        StringTokenizer st = new StringTokenizer("a,b,c", ",");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

}

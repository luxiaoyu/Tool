package com.baidu.chunlei.exercise.json;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/**
 * @author luxiaoyu01@baidu.com
 * @since 2014-4-10
 * @todo
 */
public class TestJackson {
    private static final ObjectMapper mapper = new ObjectMapper();

    private static void Jackson(String json) {
        try {
            Map<String,Object> list = mapper.readValue(json, Map.class);
//            for (int i = 0; i < list.size(); i++) {
//                Map<String, Object> map = list.get(i);
//                Set<String> set = map.keySet();
//                for (Iterator<String> it = set.iterator(); it.hasNext();) {
//                    String key = it.next();
//                }
//            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Json(String json) {
//        new JSONObject(json); 
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(new FileInputStream(
                "assets/weather.json"), "UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder(1024);

        String json;
        while ((json = streamReader.readLine()) != null) {
            responseStrBuilder.append(json);
        }
        json = responseStrBuilder.toString();
        int count = 10;

        long begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Jackson(json);
        }
        System.out.println(System.currentTimeMillis() - begin);
        
        begin = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            Json(json);
        }
        System.out.println(System.currentTimeMillis() - begin);
    }

}

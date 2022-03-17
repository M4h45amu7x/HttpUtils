package xyz.mahasamut.HttpUtils;

import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.Map;

public class Requester {

    private static final HttpUtils httpUtils = new HttpUtils();

    public static void main(String[] args) {
        try {
            Map<String, String> headers = new HashMap<>();
            headers.put("key", "value");

            JsonObject contents = new JsonObject();
            contents.addProperty("url", "https://linkvertise.com/idk");

            System.out.println(httpUtils.post("https://api.bypass.vip", headers, contents.toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

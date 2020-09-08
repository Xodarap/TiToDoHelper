package com.mrklintscher.titodohelper;

import android.util.Base64;
import com.douyin.gorgon;
import com.yanzhenjie.andserver.annotation.*;
import com.yanzhenjie.andserver.framework.body.JsonBody;
import com.yanzhenjie.andserver.http.HttpResponse;
import com.yixia.utils.TinyEncode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class MyController {
    private static HashMap<String, String> JsonObjectToHashMap(JSONObject jsonObj) throws JSONException {
        HashMap<String, String> data = new HashMap<>();
        Iterator<String> it = jsonObj.keys();
        while (it.hasNext()) {
            String key = it.next();
            String value = jsonObj.get(key).toString();
            data.put(key, value);
        }
        return data;
    }

    @GetMapping("/test")
    void postSign(HttpResponse response) {
        Map<String, String> signMap = new HashMap<>();
        signMap.put("signature", "TiToDoHelper");
        JSONObject jsonObject = new JSONObject(signMap);
        response.setBody(new JsonBody(jsonObject));
    }
}

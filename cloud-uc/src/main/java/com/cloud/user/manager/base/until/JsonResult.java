package com.cloud.user.manager.base.until;

import net.sf.json.JSONObject;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/8 13:32
 * @description：自定义工具类返回值
 * @modified By：
 * @version: 1$
 */
public class JsonResult {
    public static JSONObject success(Object obj) {
        JSONObject json = new JSONObject();
        json.put("state", true);
        json.put("msg", "成功");
        if (null != obj) {
            json.put("obj", obj);
        }
        return json;
    }

    public static JSONObject fail(Object obj) {
        JSONObject json = new JSONObject();
        json.put("state", false);
        json.put("msg", "失败");
        if (null != obj) {
            json.put("obj", obj);
        }
        return json;
    }

    public static JSONObject toJSONObject(boolean state, String msg, Object obj) {
        JSONObject json = new JSONObject();
        json.put("state", state);
        json.put("msg", msg);
        if (null != obj) {
            json.put("obj", obj);
        }
        return json;
    }
}

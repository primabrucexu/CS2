package cn.pbx.cs2.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author BruceXu
 */
public class JSON {

    public static JSONObject parse(String json) {
        return JSONUtil.parseObj(json);
    }

}

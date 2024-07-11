package cn.pbx.cs2.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.json.JSONUtil;
import cn.pbx.cs2.uuyoupin.Token;

/**
 * @author BruceXu
 */
public class CacheUtil {

    private static final String TOKEN_FILE = System.getProperty("user.home") + "uu_token.conf";

    public static void saveUUToken(Token token) {
        FileUtil.writeUtf8String(JSONUtil.toJsonStr(token), TOKEN_FILE);
    }

    public static Token getUUToken() {
        try {
            return JSONUtil.toBean(FileUtil.readUtf8String(TOKEN_FILE), Token.class);
        } catch (Exception e) {
            //            return new Token();
        }
        return null;
    }
}

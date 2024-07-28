package cn.pbx.cs2.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.pbx.cs2.exception.HttpException;
import cn.pbx.cs2.uuyoupin.API;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.slf4j.Slf4j;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author BruceXu
 */
@Slf4j
public class Http {

    private static final AsyncHttpClient CLIENT = Dsl.asyncHttpClient();

    public static JSONObject request(API api, Map<String, String> headers, Object body) {
        try {
            String responseBody = CLIENT.prepare(api.getMethod().name(), api.getEndpoint())
                    .setSingleHeaders(headers)
                    .setBody(JSONUtil.toJsonStr(body))
                    .execute()
                    .get()
                    .getResponseBody(StandardCharsets.UTF_8);
            log.debug("url:{}\nresponse body: {}", api.getEndpoint(), responseBody);
            return JSON.parse(responseBody);
        } catch (Exception e) {
            throw new HttpException(e);
        }
    }

    public static JSONObject request(API api, HttpHeaders headers, Object body) {
        try {
            String responseBody = CLIENT.prepare(api.getMethod().name(), api.getEndpoint())
                    .setHeaders(headers)
                    .setBody(JSONUtil.toJsonStr(body))
                    .execute()
                    .get()
                    .getResponseBody(StandardCharsets.UTF_8);
            log.debug("url:{}\nresponse body: {}", api.getEndpoint(), responseBody);
            return JSON.parse(responseBody);
        } catch (Exception e) {
            throw new HttpException(e);
        }
    }
}

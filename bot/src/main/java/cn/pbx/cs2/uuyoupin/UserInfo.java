package cn.pbx.cs2.uuyoupin;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.RandomUtil;
import cn.pbx.cs2.data.entity.User;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BruceXu
 */
@Data
public class UserInfo implements Serializable {

    private static final String TEMPLATE = "0123456789" + "abcdefghijklmnopqrstuvwxyz" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Serial
    private static final long serialVersionUID = -791034762555315691L;

    private final HttpHeaders headers;

    private final String deviceToken;

    private final String phone;

    private String token;

    public UserInfo(String phone) {
        this(RandomUtil.randomString(TEMPLATE, 24), phone, "");
    }

    public UserInfo(User user) {
        this(user.getDeviceToken(), user.getPhone(), user.getToken());
    }

    private UserInfo(String deviceToken, String phone, String token) {
        this.deviceToken = deviceToken;
        this.phone = phone;
        this.token = token;
        headers = new DefaultHttpHeaders()
                .set("authorization", "Bearer " + token)
                .set("content-type", "application/json; charset=utf-8")
                .set("app-version", "5.18.1")
                .set("apptype", "4")
                .set("package-type", "uuyp")
                .set("devicetoken", deviceToken)
                .set("deviceid", deviceToken)
                .set("platform", "android")
                .set("accept-encoding", "gzip")
                .set("accept", "*/*");
    }

    public User toEntity() {
        Assert.notEmpty(token, "Cannot save to DB when token is empty");
        User user = new User();
        user.setPhone(phone);
        user.setDeviceToken(deviceToken);
        user.setToken(token);
        return user;
    }

    public void setToken(String token) {
        headers.set("authorization", "Bearer " + token);
        this.token = token;
    }

    public Map<String, Object> requestSmsCodeBody() {
        Map<String, Object> body = new HashMap<>();
        body.put("Area", 86);
        body.put("Mobile", phone);
        body.put("Sessionid", deviceToken);
        body.put("Code", "");
        return body;
    }

    public Map<String, Object> loginBody(String smsCode) {
        Map<String, Object> body = new HashMap<>();
        body.put("Area", 86);
        body.put("Mobile", phone);
        body.put("Sessionid", deviceToken);
        body.put("Code", smsCode);
        body.put("TenDay", 1);
        return body;
    }

}

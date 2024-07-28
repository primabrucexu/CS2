package cn.pbx.cs2.uuyoupin;

import io.netty.handler.codec.http.HttpMethod;
import lombok.Getter;

/**
 * @author BruceXu
 */
@Getter
public enum API {

    GET_SMS_CODE("/user/Auth/SendSignInSmsCode", HttpMethod.POST),
    SMS_SIGN_IN("/user/Auth/SmsSignIn", HttpMethod.POST),
    GET_USER_INFO("/api/user/Account/getUserInfo", HttpMethod.GET),
    ;
    private static final String PREFIX = "https://api.youpin898.com/api";

    private final String endpoint;
    private final HttpMethod method;

    API(String endpoint, HttpMethod method) {
        this.endpoint = PREFIX + endpoint;
        this.method = method;
    }
}

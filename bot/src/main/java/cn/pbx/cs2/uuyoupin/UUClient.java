package cn.pbx.cs2.uuyoupin;

import cn.hutool.json.JSONObject;
import cn.pbx.cs2.exception.LoginFailedException;
import cn.pbx.cs2.util.Http;
import cn.pbx.cs2.util.Input;
import lombok.extern.slf4j.Slf4j;

/**
 * @author BruceXu
 */
@Slf4j
public class UUClient {
    private final UserInfo userInfo;

    public UUClient(UserInfo userInfo) {
        this.userInfo = userInfo;
        checkStatus();
    }

    public static UserInfo login(String phone) {
        UserInfo userInfo = new UserInfo(phone);
        JSONObject response = Http.request(API.GET_SMS_CODE, userInfo.getHeaders(), userInfo.requestSmsCodeBody());
        JSONObject signInResp;
        if (response.getInt("Code") != 5050) {
            log.info("请求短信验证码结果: {}", response.get("Msg"));
            String code = Input.get("请输入验证码");
            signInResp = Http.request(API.SMS_SIGN_IN, userInfo.getHeaders(), userInfo.loginBody(code));
            log.info("signInResp: {}", signInResp);
            String userToken = signInResp.getByPath("Data.Token", String.class);
            userInfo.setToken(userToken);
            return userInfo;
        }
        return userInfo;
    }

    void checkStatus() throws LoginFailedException {
        try {
            JSONObject jsonObject = Http.request(API.GET_USER_INFO, userInfo.getHeaders(), null);
            String userId = jsonObject.getByPath("Data.UserId", String.class);
            String nickname = jsonObject.getByPath("Data.NickName", String.class);
            log.info("user => phone: {} id: {}, nickname: {}", userInfo.getPhone(), userId, nickname);
        } catch (Exception e) {
            throw new LoginFailedException(e);
        }

    }
}

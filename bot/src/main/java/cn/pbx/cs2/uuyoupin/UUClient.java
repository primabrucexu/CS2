package cn.pbx.cs2.uuyoupin;

import cn.pbx.cs2.exception.LoginFailedException;
import cn.pbx.cs2.util.CacheUtil;
import cn.pbx.cs2.util.ConfigUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author BruceXu
 */
@Slf4j
public class UUClient {

    private final Token token;

    public UUClient(Token token) {
        this.token = token;
        checkStatus();
    }

    public static UUClient create() {
        Token token = CacheUtil.getUUToken();
        if (token.getToken() == null) {
            log.warn("Cannot get uu token from file, will start login procedure");
            return login();
        }
        try {
            return new UUClient(token);
        } catch (LoginFailedException e) {
            log.warn("Cannot login by token, will start login procedure");
            return login();
        }
    }

    private static UUClient login() {
        Token token = new Token(ConfigUtil.getPhone());

        return new UUClient(token);
    }

    private static void smsLogin(Token token) {
        WebClient client = WebClient.builder()
                .baseUrl("https://api.youpin898.com/api")
                .defaultHeader("authorization", "Bearer " + token)
                .defaultHeader("content-type", "application/json; charset=utf-8")
                .defaultHeader("user-agent", "okhttp/3.14.9")
                .defaultHeader("app-version", "5.18.1")
                .defaultHeader("apptype", "4")
                .defaultHeader("package-type", "uuyp")
                .defaultHeader("devicetoken", token.getDeviceToken())
                .defaultHeader("deviceid", token.getDeviceToken())
                .defaultHeader("platform", "android")
                .defaultHeader("package-type", "uuyp")
                .defaultHeader("accept-encoding", "gzip")
                .build();
    }

    private void checkStatus() throws LoginFailedException {}
}

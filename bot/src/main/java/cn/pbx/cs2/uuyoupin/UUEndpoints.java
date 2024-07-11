package cn.pbx.cs2.uuyoupin;

/**
 * @author BruceXu
 */
public class UUEndpoints {

    private static final String PREFIX = "https://api.youpin898.com/api";

    interface Login {
        String GET_SMS_CODE = PREFIX + "/user/Auth/SendSignInSmsCode";
        String SMS_SIGN_IN = "/user/Auth/SmsSignIn";
        String SMS_SIGN_IN_TYPE2 = "/user/Auth/SmsUpSignIn";
    }

    interface User {
        String USER_INFO = "/user/Account/getUserInfo";
    }

    interface Rent {}

    interface Sell {}

    interface Buy {}
}

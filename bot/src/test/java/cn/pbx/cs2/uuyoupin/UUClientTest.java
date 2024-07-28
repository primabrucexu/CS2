package cn.pbx.cs2.uuyoupin;

import cn.pbx.cs2.data.entity.User;
import cn.pbx.cs2.data.repository.UserRepository;
import cn.pbx.cs2.util.Input;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

/**
 * @author BruceXu
 */
@SpringBootTest
class UUClientTest {

    private static final Logger log = LoggerFactory.getLogger(UUClientTest.class);

    @Autowired
    UserRepository userRepository;

    @Test
    void loginTest() {
        String phone = Input.get("请输入手机号：");
        Optional<User> userInDB = userRepository.findByPhone(phone);
        UserInfo userInfo;
        if (userInDB.isPresent()) {
            userInfo = new UserInfo(userInDB.get());
        } else {
            log.info("未找到[{}]的登录记录，需要重新登录", phone);
            userInfo = UUClient.login(phone);
            userRepository.saveAndFlush(userInfo.toEntity());
        }

        UUClient client = new UUClient(userInfo);
        client.checkStatus();
    }
}
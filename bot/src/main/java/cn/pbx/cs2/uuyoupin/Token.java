package cn.pbx.cs2.uuyoupin;

import cn.pbx.cs2.util.Random;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author BruceXu
 */
@Data
public class Token implements Serializable {

    @Serial
    private static final long serialVersionUID = -791034762555315691L;

    @JsonIgnore
    private final String deviceToken;

    private String token;
    private String phone;

    public Token(String token, String phone) {
        this.token = token;
        this.phone = phone;
        this.deviceToken = Random.getInstance(token.hashCode()).get(24);
    }

    public Token(String phone) {
        this("", phone);
    }
}

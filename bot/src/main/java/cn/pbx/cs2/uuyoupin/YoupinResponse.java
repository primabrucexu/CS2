package cn.pbx.cs2.uuyoupin;

import cn.hutool.json.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author BruceXu
 */
@Data
public class YoupinResponse {

    @JsonProperty("Code")
    int code;

    @JsonProperty("TipType")
    int tipType;

    @JsonProperty("Msg")
    String msg;

    @JsonProperty("Data")
    JSONObject data;
}

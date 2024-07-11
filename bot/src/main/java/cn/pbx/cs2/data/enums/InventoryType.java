package cn.pbx.enums;

import lombok.Getter;

/**
 * @author BruceXu
 */
@Getter
public enum InventoryType {
    Cases(),
    Rifles(DetailType.AK47),
    Pistols(DetailType.P250),
    Knives(DetailType.Butterfly_Knife),
    Gloves(DetailType.Driver_Gloves);

    private final DetailType[] detailTypes;

    InventoryType(DetailType... detailTypes) {
        this.detailTypes = detailTypes;
    }
}

package cn.pbx.cs2.data.dto;

import cn.pbx.enums.DetailType;
import cn.pbx.enums.InventoryType;
import cn.pbx.enums.Usage;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO for {@link cn.pbx.cs2.data.entity.Inventory}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record InventoryDto(
        Long id,
        InventoryType inventoryType,
        DetailType detailType,
        String skinName,
        Date buyDate,
        BigDecimal buyPrice,
        Date sellDate,
        BigDecimal sellPrice,
        Usage usage,
        BigDecimal benefitDiscount)
        implements Serializable {}

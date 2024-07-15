package cn.pbx.cs2.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * DTO for {@link cn.pbx.cs2.data.entity.RentRecord}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record RentRecordDto(
        Long id,
        InventoryDto inventory,
        Date startDate,
        Date endDate,
        BigDecimal singlePrice,
        Integer rentalDays,
        BigDecimal totalPrice,
        BigDecimal totalBenefit)
        implements Serializable {}

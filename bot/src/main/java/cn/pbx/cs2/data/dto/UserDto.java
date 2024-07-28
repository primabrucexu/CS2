package cn.pbx.cs2.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * DTO for {@link cn.pbx.cs2.data.entity.User}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record UserDto(Long id, String phone, String deviceToken, String token) implements Serializable {
}
package dev.chk.UrlShortener.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@JsonAutoDetect
@NoArgsConstructor
@AllArgsConstructor
public class UrlAddDto {
    @JsonProperty("fullUrl")
    private String fullUrl;
}

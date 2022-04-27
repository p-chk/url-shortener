package dev.chk.UrlShortener.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UrlMainEntity {
    private Long id;

    @EqualsAndHashCode.Include
    private String fullUrl;
    @EqualsAndHashCode.Include
    private String shortUrl;
    private String createdBy;
    private LocalDateTime createdAt;
    private String lastModifiedBy;
    private LocalDateTime lastModifiedAt;
}

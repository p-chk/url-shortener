package dev.chk.UrlShortener.model;

import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@Entity
@Table(name = "url_main")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class UrlMainEntity {

    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "fullUrl")
    private String fullUrl;

    @EqualsAndHashCode.Include
    @Column(name = "short_url")
    private String shortUrl;

    @Column(name = "created_by")
    @CreatedBy
    @Builder.Default
    private String createdBy = "SERVICE";

    @Column(name = "createdAt", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "lastModifiedBy")
    @LastModifiedBy
    @Builder.Default
    private String lastModifiedBy = "SERVICE";

    @Column(name = "lastModifiedAt", nullable = false)
    @LastModifiedDate
    private LocalDateTime lastModifiedAt;
}

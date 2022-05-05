package dev.chk.UrlShortener.repository;

import dev.chk.UrlShortener.model.UrlMainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlMainRepository extends JpaRepository<UrlMainEntity, Long> {
}

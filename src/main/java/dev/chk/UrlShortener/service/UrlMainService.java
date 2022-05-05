package dev.chk.UrlShortener.service;

import dev.chk.UrlShortener.model.UrlMainEntity;

public interface UrlMainService {
    void save(UrlMainEntity urlMainEntity);
    UrlMainEntity findByShortenedUrl(String shortenedUrl);

    Long countRows();
}

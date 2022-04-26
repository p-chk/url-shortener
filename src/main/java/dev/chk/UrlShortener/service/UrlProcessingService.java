package dev.chk.UrlShortener.service;

public interface UrlProcessingService {
    String getShortenedUrl();
    void processFullUrl();
    String getFullUrl(String shortenedUrl);
}

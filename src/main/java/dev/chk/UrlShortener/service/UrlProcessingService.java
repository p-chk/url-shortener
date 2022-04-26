package dev.chk.UrlShortener.service;

public interface UrlProcessingService {
    String getShortenedUrl();
    String processFullUrl();
    String getFullUrl(String shortenedUrl);
}

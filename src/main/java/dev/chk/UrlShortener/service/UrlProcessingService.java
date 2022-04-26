package dev.chk.UrlShortener.service;

public interface UrlProcessingService {
    String getShortenedUrl();
    String processFullUrl(String fullUrl);

    String getFullUrl(String shortenedUrl);
}

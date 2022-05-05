package dev.chk.UrlShortener.service;

import dev.chk.UrlShortener.model.UrlMainEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlProcessingServiceImpl implements UrlProcessingService {
    private final UrlMainService urlMainService;
    @Override
    public String getShortenedUrl() {
        return String.valueOf(urlMainService.countRows() + 1);
    }

    @Override
    public String processFullUrl(String fullUrl) {
        String shortenedUrl = getShortenedUrl();
        saveUrl(UrlMainEntity.builder().fullUrl(fullUrl).shortUrl(shortenedUrl).build());
        return shortenedUrl;
    }

    @Override
    public String getFullUrl(String shortenedUrl) {
        return urlMainService.findByShortenedUrl(shortenedUrl).getFullUrl();
    }

    private void saveUrl(UrlMainEntity urlMainEntity) {
        urlMainService.save(urlMainEntity);
    }
}

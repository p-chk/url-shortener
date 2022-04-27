package dev.chk.UrlShortener.service;

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
        return null;
    }

    @Override
    public String getFullUrl(String shortenedUrl) {
        return null;
    }

    private void saveUrl() {

    }
}

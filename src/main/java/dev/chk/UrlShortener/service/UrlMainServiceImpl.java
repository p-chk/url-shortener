package dev.chk.UrlShortener.service;

import dev.chk.UrlShortener.model.UrlMainEntity;
import dev.chk.UrlShortener.repository.UrlMainRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlMainServiceImpl implements UrlMainService {
    private final UrlMainRepository urlMainRepository;

    @Override
    public void save(UrlMainEntity urlMainEntity) {
        urlMainRepository.save(urlMainEntity);
    }

    @Override
    public UrlMainEntity findByShortenedUrl(String shortenedUrl) {
        return urlMainRepository.findByShortUrl(shortenedUrl).orElse(null);
    }

    @Override
    public Long countRows() {
        return urlMainRepository.count();
    }
}

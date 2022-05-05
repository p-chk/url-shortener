package dev.chk.UrlShortener.Service;

import dev.chk.UrlShortener.model.UrlMainEntity;
import dev.chk.UrlShortener.repository.UrlMainRepository;
import dev.chk.UrlShortener.service.UrlMainServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UrlMainServiceTest {
    @InjectMocks
    UrlMainServiceImpl urlMainService;
    @Mock
    UrlMainRepository urlMainRepository;

    @Test
    void save_should_callUrlMainRepositorySave() {
        UrlMainEntity toSaveUrl = UrlMainEntity.builder().build();
        urlMainService.save(toSaveUrl);

        verify(urlMainRepository).save(toSaveUrl);
    }

    @Test
    void findByShortenedUrl_should_returnFindByShortUrl_whenUrlDoesExist() {
        Optional<UrlMainEntity> expected = Optional.of(UrlMainEntity.builder().build());
        doReturn(expected).when(urlMainRepository).findByShortUrl("shortenedUrl");

        UrlMainEntity actual = urlMainService.findByShortenedUrl("shortenedUrl");

        assertThat(actual).isEqualTo(expected.get());
        verify(urlMainRepository).findByShortUrl("shortenedUrl");
    }

    @Test
    void findByShortenedUrl_should_returnNull_whenUrlDoesNotExist() {
        doReturn(Optional.empty()).when(urlMainRepository).findByShortUrl("shortenedUrl");

        UrlMainEntity actual = urlMainService.findByShortenedUrl("shortenedUrl");

        assertThat(actual).isEqualTo(null);
        verify(urlMainRepository).findByShortUrl("shortenedUrl");
    }

    @Test
    void countRows_should_callCount() {
        urlMainService.countRows();

        verify(urlMainRepository).count();
    }

}

package dev.chk.UrlShortener.Service;

import dev.chk.UrlShortener.exception.UrlNotFoundException;
import dev.chk.UrlShortener.model.UrlMainEntity;
import dev.chk.UrlShortener.service.UrlMainService;
import dev.chk.UrlShortener.service.UrlProcessingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UrlProcessingServiceImplTest {
    @Spy
    @InjectMocks
    UrlProcessingServiceImpl urlProcessingService;

    @Mock
    UrlMainService urlMainService;


    @Test
    void getShortenedUrl_should_returnShortenUrl() {
        doReturn(0).when(urlMainService).countRows();
        String expect = "1";

        String actual = urlProcessingService.getShortenedUrl();

        verify(urlMainService).countRows();
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void getShortenedUrl_should_throwException_whenUrlMainServiceThrowException() {
        doThrow(NullPointerException.class).when(urlMainService).countRows();

        assertThrows(NullPointerException.class, () -> {
            urlProcessingService.getShortenedUrl();
        });

        verify(urlMainService).countRows();
    }

    @Test
    void processFullUrl_should_callGetShortenedUrlAndSaveUrlToUrlMainAndReturnShortenedUrl_whenFullUrlIsGiven() {
        doReturn("1").when(urlProcessingService).getShortenedUrl();
        String expect = "1";
        String actual = urlProcessingService.processFullUrl("fullUrl");

        verify(urlProcessingService).getShortenedUrl();
        verify(urlMainService).save(UrlMainEntity.builder().fullUrl("fullUrl").shortUrl("1").build());
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void processFullUrl_should_throwException_whenSaveUrlThrowsExcpetion() {
        doThrow(NullPointerException.class).when(urlMainService).save(UrlMainEntity.builder().fullUrl("fullUrl").shortUrl("1").build());
        String expect = "1";
        assertThrows(NullPointerException.class, () -> {
            String actual = urlProcessingService.processFullUrl("fullUrl");

            verify(urlProcessingService).getShortenedUrl();
            assertThat(actual).isEqualTo(expect);
            verify(urlMainService).save(UrlMainEntity.builder().fullUrl("fullUrl").shortUrl("1").build());
        });
    }
    @Test
    void getFullUrl_should_callFindFullUrlByShortUrlAndReturn() {
        doReturn(UrlMainEntity.builder().fullUrl("fullUrl").build()).when(urlMainService).findByShortenedUrl("shortUrl");
        String expected = "fullUrl";

        String actual = urlProcessingService.getFullUrl("shortUrl");

        assertThat(actual).isEqualTo(expected);
        verify(urlMainService).findByShortenedUrl("shortUrl");
    }

    @Test
    void getFullUrl_should_throwError_whenCannotFindFullUrl() {
        doReturn(null).when(urlMainService).findByShortenedUrl("shortUrl");

        assertThrows(UrlNotFoundException.class, () -> {
            urlProcessingService.getFullUrl("shortUrl");
        });

        verify(urlMainService).findByShortenedUrl("shortUrl");
    }
}

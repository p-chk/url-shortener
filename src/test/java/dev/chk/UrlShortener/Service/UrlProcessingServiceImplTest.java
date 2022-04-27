package dev.chk.UrlShortener.Service;

import dev.chk.UrlShortener.service.UrlMainService;
import dev.chk.UrlShortener.service.UrlProcessingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UrlProcessingServiceImplTest {

    @InjectMocks
    UrlProcessingServiceImpl urlProcessingService;

    @Mock
    UrlMainService urlMainService;


    @Test
    void getShortenedUrl_should_returnShortenUrl() {
        doReturn(0).when(urlMainService.countRows());
        String expect = "1";
        String actual = urlProcessingService.getShortenedUrl();

        verify(urlMainService).countRows();
        assertThat(actual).isEqualTo(expect);
    }
}

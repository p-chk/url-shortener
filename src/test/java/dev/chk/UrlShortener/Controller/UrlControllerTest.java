package dev.chk.UrlShortener.Controller;

import dev.chk.UrlShortener.controller.UrlController;
import dev.chk.UrlShortener.service.UrlProcessingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UrlControllerTest {
    @InjectMocks
    private UrlController urlController;

    @Mock
    private UrlProcessingService urlProcessingService;

    @Test
    void getLongUrl_should_returnModelViewOfLongUrl_whenUrlProcessingServiceCanReturnSuccessfully() {
        doReturn("fullUrl").when(urlProcessingService).getFullUrl("shortenUrl");

        ModelAndView result = urlController.getLongUrl("shortenUrl");

        verify(urlProcessingService).getFullUrl("shortenUrl");
        assertThat(result.getViewName()).contains("redirect:https://fullUrl");
    }

    @Test
    void getLongUrl_should_returnNull_WhenThereAreException() {
        doThrow(NullPointerException.class).when(urlProcessingService).getFullUrl("shortenUrl");

        ModelAndView result = urlController.getLongUrl("shortenUrl");

        verify(urlProcessingService).getFullUrl("shortenUrl");
        assertThat(result).isNull();
    }
}

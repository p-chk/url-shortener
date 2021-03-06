package dev.chk.UrlShortener.controller;

import dev.chk.UrlShortener.dto.UrlAddDto;
import dev.chk.UrlShortener.service.UrlProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class UrlController {

    private final UrlProcessingService urlProcessingService;
    @GetMapping("/{shortenedUrl}")
    public ModelAndView getLongUrl(@PathVariable String shortenedUrl) {
        try {
            String fullUrl = urlProcessingService.getFullUrl(shortenedUrl);
            return new ModelAndView("redirect:" + String.format("https://%s", fullUrl));
        } catch (Exception ex) {
            log.error("Failed due to {}", ex.getMessage());
            return null;
        }
    }

    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUrl(@RequestBody UrlAddDto fullUrl) {
        try {
            String shortenedUrl = urlProcessingService.processFullUrl(fullUrl.getFullUrl());
            HashMap<String, Object> body = new HashMap<>();
            body.put("shortenedUrl", shortenedUrl);
            return ResponseEntity.ok().body(body);
        } catch (Exception ex) {
            log.debug("Failed due to {}", ex.getMessage());
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }

    }
}

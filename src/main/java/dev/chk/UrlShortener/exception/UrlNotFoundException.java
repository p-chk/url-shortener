package dev.chk.UrlShortener.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UrlNotFoundException extends RuntimeException {
    private final String message;
}

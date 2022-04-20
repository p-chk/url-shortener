package dev.chk.UrlShortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlController {

    @GetMapping("/{shortenHashCode}")
    public ModelAndView getLongUrl(@PathVariable String shortenHashCode) {
        return new ModelAndView("redirect:" + String.format("https://%s", shortenHashCode));
    }

    @PostMapping(path = "/add",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addUrl(@RequestBody String fullUrl) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

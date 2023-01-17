package com.homeworkresttemplate.resttemplatehomework.controller;
import com.homeworkresttemplate.resttemplatehomework.service.SentenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RestTemplateController {


    private final SentenceService service;

    @GetMapping("sentence")
    public ResponseEntity<String> sentenceLinkDTO(@RequestParam String name, String fromDil, String toDil){
        return service.sentenceMethod(name, fromDil, toDil);
    }
}

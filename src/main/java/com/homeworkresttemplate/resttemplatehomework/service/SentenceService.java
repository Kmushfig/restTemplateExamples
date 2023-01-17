package com.homeworkresttemplate.resttemplatehomework.service;

import com.homeworkresttemplate.resttemplatehomework.dto.SentenceLinkDTO;
import org.springframework.http.*;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.OutputKeys;
import java.util.HashMap;
import java.util.Map;

@Service
public class SentenceService {
    public ResponseEntity sentenceMethod(String name, String fromDil, String toDil) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://condamne-create-your-sentence.p.rapidapi.com/translate?word=${name}&from=${fromDil}&to=${toDil}";

        Map<String, String> params = new HashMap<>();
        params.put("name", name);
        params.put("fromDil", fromDil);
        params.put("toDil", toDil);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("X-RapidAPI-Key", "b3148b55f3mshd1f4f84bc958b8bp137470jsn087b9c7dee3c");

        ResponseEntity<SentenceLinkDTO> exchange = restTemplate.exchange(url, HttpMethod.GET,
                null, SentenceLinkDTO.class, params);

        System.out.println(exchange.getBody().fromLang);
        System.out.println(exchange.getBody().toLang);

//        System.out.println(exchange.getBody());

//      SentenceLinkDTO forObject = restTemplate.getForObject("", SentenceLinkDTO.class);
//        return new ResponseEntity<SentenceLinkDTO>(forObject, HttpStatus.OK);


        return null;
    }
}

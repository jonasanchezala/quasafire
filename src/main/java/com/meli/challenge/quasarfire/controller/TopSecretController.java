package com.meli.challenge.quasarfire.controller;

import com.meli.challenge.quasarfire.model.TopSecretRequest;
import com.meli.challenge.quasarfire.service.TopSecretService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class TopSecretController {

    private final TopSecretService topSecretService;

    @PostMapping("/topsecret")
    public ResponseEntity topSecret(@RequestBody final TopSecretRequest topSecretRequest) {
        try{
            return ResponseEntity.ok(topSecretService.topSecret(topSecretRequest));
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

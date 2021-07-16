package com.meli.challenge.quasarfire.controller;

import com.meli.challenge.quasarfire.exception.NotEnoughInformationException;
import com.meli.challenge.quasarfire.model.TopSecretRequest;
import com.meli.challenge.quasarfire.model.TopSecretSplitRequest;
import com.meli.challenge.quasarfire.service.TopSecretService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

    @PostMapping("/topsecret_split/{satelliteName}")
    public ResponseEntity saveTopSecretSplit(@PathVariable final String satelliteName,
                                @RequestBody final TopSecretSplitRequest topSecretSplitRequest) {
        try{
            topSecretService.topSecretSplit(satelliteName, topSecretSplitRequest);
            return ResponseEntity.created(new URI("/topsecret_split")).build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/topsecret_split")
    public ResponseEntity getTopSecretSplit() {
        try{
            return ResponseEntity.ok(topSecretService.getTopSecretSplit());
        }
        catch (NotEnoughInformationException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @DeleteMapping("/topsecret_split")
    public ResponseEntity deleteTopSecretSplit() {
        try{
            topSecretService.deleteTopSecretSplit();
            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

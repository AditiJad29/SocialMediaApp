package com.practice.social.media.controller;

import com.practice.social.media.models.SocialUser;
import com.practice.social.media.service.SocialMediaService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media/v1/")
public class SocialMediaController {

    @Autowired
    private SocialMediaService socialMediaService;

    @GetMapping("/users")
    public ResponseEntity<List<SocialUser>> getUsers() {
        return ResponseEntity.ok(socialMediaService.getAllUsers());
    }

    @PostMapping("/user")
    public ResponseEntity<SocialUser> saveUser(@RequestBody SocialUser user){
        return ResponseEntity.ok(socialMediaService.saveUser(user));
    }


}

package com.practice.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
One to One
Profile--->User
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
    @JoinColumn(name="social_user_id")
    @JsonIgnore
    private SocialUser user;

    public void setSocialUser(SocialUser socialUser){
        this.user = socialUser;
        if (user.getUserProfile() != this)
            user.setSocialProfile(this);
    }
}

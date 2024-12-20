package com.practice.social.media.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
ManyToMany: User<--->UserGroup
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialUserGroup {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "groups")
    @JsonIgnore
    private Set<SocialUser> users = new HashSet<>();

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

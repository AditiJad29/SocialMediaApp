package com.practice.social.media.service;

import com.practice.social.media.models.SocialProfile;
import com.practice.social.media.models.SocialUser;
import com.practice.social.media.repository.SocialPostRepository;
import com.practice.social.media.repository.SocialProfileRepository;
import com.practice.social.media.repository.SocialUserGroupRepository;
import com.practice.social.media.repository.SocialUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialMediaService {

    private SocialUserRepository socialUserRepository;
    private SocialProfileRepository socialProfileRepository;
    private SocialPostRepository socialPostRepository;
    private SocialUserGroupRepository socialUserGroupRepository;

    public SocialMediaService(SocialUserRepository socialUserRepository, SocialProfileRepository socialProfileRepository, SocialPostRepository socialPostRepository, SocialUserGroupRepository socialUserGroupRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.socialPostRepository = socialPostRepository;
        this.socialUserGroupRepository = socialUserGroupRepository;
    }

    public List<SocialUser> getAllUsers() {
        return socialUserRepository.findAll();
    }

    public SocialUser saveUser(SocialUser toSaveUser) {
        return socialUserRepository.save(toSaveUser);
    }
}

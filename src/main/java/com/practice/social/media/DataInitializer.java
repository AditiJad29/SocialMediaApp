package com.practice.social.media;

import com.practice.social.media.models.SocialPost;
import com.practice.social.media.models.SocialProfile;
import com.practice.social.media.models.SocialUser;
import com.practice.social.media.models.SocialUserGroup;
import com.practice.social.media.repository.SocialPostRepository;
import com.practice.social.media.repository.SocialProfileRepository;
import com.practice.social.media.repository.SocialUserGroupRepository;
import com.practice.social.media.repository.SocialUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    private SocialUserRepository socialUserRepository;
    private SocialProfileRepository socialProfileRepository;
    private SocialPostRepository socialPostRepository;
    private SocialUserGroupRepository socialUserGroupRepository;

    public DataInitializer(SocialUserRepository socialUserRepository, SocialProfileRepository socialProfileRepository, SocialPostRepository socialPostRepository, SocialUserGroupRepository socialUserGroupRepository) {
        this.socialUserRepository = socialUserRepository;
        this.socialProfileRepository = socialProfileRepository;
        this.socialPostRepository = socialPostRepository;
        this.socialUserGroupRepository = socialUserGroupRepository;
    }

    @Bean
    public CommandLineRunner setUp(){

        return args -> {

            // Create some users
            SocialUser user1 = new SocialUser();
            SocialUser user2 = new SocialUser();
            SocialUser user3 = new SocialUser();
            user1.setFirstName("Aditi");
            user2.setFirstName("Mishu");
            user3.setFirstName("Ashish");
            // Save users to the database
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);

            // Create some social profiles
            SocialProfile profile1 = new SocialProfile();
            SocialProfile profile2 = new SocialProfile();
            SocialProfile profile3 = new SocialProfile();
            // Associate profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);
            // Save profiles to the database
            socialProfileRepository.save(profile1);
            socialProfileRepository.save(profile2);
            socialProfileRepository.save(profile3);

            //As User is the relationship owner, save to user entity
            user1.setUserProfile(profile1);
            user2.setUserProfile(profile2);
            user3.setUserProfile(profile3);

            //Create some posts
            SocialPost post1a = new SocialPost();
            SocialPost post1b = new SocialPost();
            SocialPost post2 = new SocialPost();
            SocialPost post3 = new SocialPost();

            post1a.setCreator(user1);
            post1b.setCreator(user1);
            post2.setCreator(user2);
            post3.setCreator(user3);
            socialPostRepository.saveAll(List.of(post1a,post1b,post2,post3));

            user1.setUserPosts(List.of(post1a,post1b));
            user2.setUserPosts(List.of(post2));
            user3.setUserPosts(List.of(post3));

            // Create some groups
            SocialUserGroup group1 = new SocialUserGroup();
            SocialUserGroup group2 = new SocialUserGroup();

            // Add users to groups
            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            // Save groups to the database
            socialUserGroupRepository.save(group1);
            socialUserGroupRepository.save(group2);

            // Associate users with groups
            user1.getGroups().add(group1);
            user2.getGroups().add(group1);
            user2.getGroups().add(group2);
            user3.getGroups().add(group2);

            // Save users back to database to update associations of groups and posts
            socialUserRepository.save(user1);
            socialUserRepository.save(user2);
            socialUserRepository.save(user3);
        };
    }
}

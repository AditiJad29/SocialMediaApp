package com.practice.social.media.repository;

import com.practice.social.media.models.SocialPost;
import com.practice.social.media.models.SocialProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialProfileRepository extends JpaRepository<SocialProfile,Long> {
}

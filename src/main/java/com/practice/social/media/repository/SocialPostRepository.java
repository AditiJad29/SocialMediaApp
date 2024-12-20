package com.practice.social.media.repository;

import com.practice.social.media.models.SocialPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocialPostRepository extends JpaRepository<SocialPost,Long> {
}

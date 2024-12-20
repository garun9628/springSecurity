package com.SpringSecurity.SpringSecurityApplication.services;

import com.SpringSecurity.SpringSecurityApplication.dto.PostDto;

import java.util.List;

//@Service // we can't create beans for interfaces
 public interface PostService {
    List<PostDto> getAllPosts();

    PostDto createNewPost(PostDto inputPost);

    PostDto getPostById(Long postId);

    PostDto updatePost(PostDto inputPost, Long id);
}

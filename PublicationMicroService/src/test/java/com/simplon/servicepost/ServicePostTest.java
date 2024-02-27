package com.simplon.servicepost;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ServicePostTest {

    private Ipost postService;

    @Autowired
    ServicePostTest(Ipost postService1){
        this.postService = postService1;
    }
    PostDTO postDTO;
    @BeforeEach
    void setUp() {
        postDTO = new PostDTO();
        postDTO.setContent("Hello");
        postDTO.setUserId(1);
        postDTO.setFileId(1);
        postDTO.setDatePost("2021-07-01");
        postDTO.setDeleted(false);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addPost() {
      PostDTO post= postService.addPost(postDTO);
      assertEquals(post.getContent(),postDTO.getContent());
    }

    @Test
    void deletePost() {
        PostDTO post= postService.addPost(postDTO);
        boolean result = postService.deletePost(post.getPostId());
        assertTrue(result);
    }

    @Test
    void updatePost() {
        PostDTO post= postService.addPost(postDTO);
        String content=post.getContent();
        post.setContent("helloworld");
        PostDTO postDTO1=postService.updatePost(post,post.getPostId());
        assertEquals(content,postDTO1.getContent());
    }

    @Test
    void getPost() {
        String s="MC-12";
    }

    @Test
    void getAllPosts() {
    }

    @Test
    void getPostsByUser() {
    }
}
package com.blog.springboardpost.domain;

import java.time.LocalDateTime;

public class Article {
    private Long id;
    private String title;
    private String content;
    private String hash_tag;

    private LocalDateTime created_at;
    private String created_by;
    private LocalDateTime modified_at;
    private String modified_by;
}

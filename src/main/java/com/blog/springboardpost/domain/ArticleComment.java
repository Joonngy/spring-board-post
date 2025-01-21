package com.blog.springboardpost.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article;
    private String content;

    private LocalDateTime created_at;
    private String created_by;
    private LocalDateTime modified_at;
    private String modified_by;
}

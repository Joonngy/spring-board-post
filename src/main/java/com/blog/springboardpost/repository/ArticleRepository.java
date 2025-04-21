package com.blog.springboardpost.repository;

import com.blog.springboardpost.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
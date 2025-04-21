package com.blog.springboardpost.repository;

import com.blog.springboardpost.config.JpaConfig;
import com.blog.springboardpost.domain.Article;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("JPA 연결 테스트")
@Import(JpaConfig.class)
@DataJpaTest
class JpaRepositoryTest {
    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    public JpaRepositoryTest(@Autowired ArticleRepository articleRepository, @Autowired ArticleCommentRepository articleCommentRepository) {
        this.articleRepository = articleRepository;
        this.articleCommentRepository = articleCommentRepository;
    }

    @DisplayName("Select Test")
    @Test
    void givenTestData_whenSelecting_thenWorksFine() {
        // Given

        // When
        List<Article> articles = articleRepository.findAll();

        // That
        assertThat(articles).hasSize(0);
    }

    @DisplayName("Insert Test")
    @Test
    void givenTestData_whenInserting_thenWorksFine() {
        // Given
        long previousArticleCount = articleRepository.count();

        // When
        Article savedArticle = articleRepository.save(Article.of("new article", "new content", "con"));

        // That
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount + 1);
    }

    @DisplayName("Update Test")
    @Test
    void givenTestData_whenUpdating_thenWorksFine() {
        // Given
        Article article = this.articleRepository.findById(1L).orElseThrow();
        String updatedHashtag = "#springboot";
        article.setHash_tag(updatedHashtag);

        // When
        Article savedArticle = articleRepository.saveAndFlush(article);

        // That
        assertThat(savedArticle).hasFieldOrPropertyWithValue("hashtag", updatedHashtag);
    }

    @DisplayName("Delete Test")
    @Test
    void givenTestData_whenDeleting_thenWorksFine() {
        // Given
        Article article = articleRepository.findById(1L).orElseThrow();
        Long previousArticleCount = this.articleRepository.count();
        Long previousArticleCommentCount = this.articleCommentRepository.count();
        int deletedCommentsCount = article.getArticleComments().size();

        // When
        articleRepository.delete(article);

        // That
        assertThat(articleRepository.count()).isEqualTo(previousArticleCount - 1);
        assertThat(articleCommentRepository.count()).isEqualTo(previousArticleCommentCount - deletedCommentsCount);
    }
}
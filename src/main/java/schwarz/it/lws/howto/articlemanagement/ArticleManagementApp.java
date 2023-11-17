package schwarz.it.lws.howto.articlemanagement;

import schwarz.it.lws.howto.articlemanagement.model.Article;
import schwarz.it.lws.howto.articlemanagement.service.ArticleMangementService;

import java.util.Arrays;
import java.util.List;

public class ArticleManagementApp {
    public static void main(String[] args) {
        ArticleMangementService articleMangementService = new ArticleMangementService();

        List<Article> articles = Arrays.asList(
                new Article("Artikel 1", "Kategorie 1", 100, 1.99),
                new Article("Artikel 2", "Kategorie 1", 100, 2.99),
                new Article("Artikel 3", "Kategorie 2", 100, 3.99),
                new Article("Artikel 4", "Kategorie 2", 100, 4.99),
                new Article("Artikel 5", "Kategorie 3", 100, 5.99),
                new Article("Artikel 6", "Kategorie 3", 100, 6.99)
        );

        articles.forEach(System.out::println);

        List<Article> savedArticles = articleMangementService.saveAll(articles);

        savedArticles.forEach(System.out::println);

    }
}

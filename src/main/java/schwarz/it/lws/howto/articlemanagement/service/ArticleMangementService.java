package schwarz.it.lws.howto.articlemanagement.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import schwarz.it.lws.howto.articlemanagement.model.Article;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class ArticleMangementService {
    private static final String ARTICLE_DATA_FILENAME = "article.json";

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Article> readAllArticles() {
        try {
            return readArticlesFromJsonFile(ARTICLE_DATA_FILENAME);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read article data. " + e.getMessage());
        }
    }

    public List<Article> saveAll(List<Article> articles) {
        AtomicLong id = new AtomicLong();
        articles.forEach(article -> article.setId(id.incrementAndGet()));

        try {
            writeToJsonFile(articles, ARTICLE_DATA_FILENAME);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write articles:");
        }
        return articles;
    }

    private void writeToJsonFile(List<Article> artikels, String filename) throws IOException {
        objectMapper.writeValue(new File(filename), artikels);
    }

    private List<Article> readArticlesFromJsonFile(String filename) throws IOException {
        return objectMapper.readValue(new File(filename), new TypeReference<List<Article>>() {
        });
    }

}

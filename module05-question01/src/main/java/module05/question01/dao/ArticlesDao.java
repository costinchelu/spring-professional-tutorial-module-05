package module05.question01.dao;

import module05.question01.ds.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticlesDao extends CrudRepository<Article, Integer> {
}

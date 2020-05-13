package challenge;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuoteRepository extends CrudRepository<Quote, Integer> {

    List<Quote> findAll();

    List<Quote> findAllByActor(String actor);
}

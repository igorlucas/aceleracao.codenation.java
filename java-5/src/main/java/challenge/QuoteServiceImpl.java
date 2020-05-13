package challenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class QuoteServiceImpl implements QuoteService {

	@Autowired
	private QuoteRepository repository;

	@Override
	public Quote getQuote() {
		List<Quote> quoteList = repository.findAll();
		Random gerador = new Random();
		int index = gerador.nextInt(quoteList.size());
		return quoteList.get(index);
	}

	@Override
	public Quote getQuoteByActor(String actor) {
		List<Quote> quoteList = repository.findAllByActor(actor);
		Random gerador = new Random();
		int index = gerador.nextInt(quoteList.size());
		return quoteList.get(index);
	}

}

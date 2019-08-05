package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {

	public <T> Optional<T> request(Filme filme, Class<T> tClass) {
		RestTemplate client = new RestTemplate();
		String titulo = filme.getNome().replace(" ", "+");
		String url = String.format("https://omdb-fj22.herokuapp.com/movie?title=%s", titulo);
		
		try {
			T detalhes = client.getForObject(url, tClass);
			System.out.println("Fetch realizado com sucesso! Detalhes: \n" + detalhes);
			return Optional.ofNullable(detalhes);
		} catch (RestClientException e) {
			System.out.println("Falha ao se comunicar com a API");
			return Optional.empty();
		}
	}
}

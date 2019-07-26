package br.com.caelum.ingresso.validacao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {

	private List<Sessao> sessoesDaSala;

	public GerenciadorDeSessao(List<Sessao> sessoesDaSala) {
		this.sessoesDaSala = sessoesDaSala;
	}
	
	public boolean cabe(Sessao sessaoNova) {
		if (terminaAmanha(sessaoNova)) {
			return false;
		}
		
		return sessoesDaSala.stream()
				.noneMatch(sessaoExistente -> 
					horarioIsConflitante(sessaoExistente, sessaoNova)
				);
	}
	
	private boolean terminaAmanha(Sessao sessao) {
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessao);
		// Estou juntando em um LocalDateTime um LocalDate e um LocalTime
		LocalDateTime ultimoSegundoDeHoje = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);
		
		if (ultimoSegundoDeHoje.isBefore(terminoSessaoNova)) {
			return true;
		}
		
		return false;
	}

	private LocalDateTime getTerminoSessaoComDiaDeHoje(Sessao sessao) {
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessao);
		return inicioSessaoNova.plus(sessao.getFilme().getDuracao());
	}
	
	private LocalDateTime getInicioSessaoComDiaDeHoje(Sessao sessao) {
		LocalDate hoje = LocalDate.now();
		return sessao.getHorario().atDate(hoje);
	}

	private boolean horarioIsConflitante(Sessao sessaoExistente, Sessao sessaoNova) {
		LocalDateTime inicioSessaoExistente = getInicioSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime terminoSessaoExistente = getTerminoSessaoComDiaDeHoje(sessaoExistente);

		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessaoNova);
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessaoNova);
		
		boolean sessaoNovaTerminaAntesDaExistente = terminoSessaoNova.isBefore(inicioSessaoExistente);
		
		boolean sessaoExistenteTerminaAntesDaNova = terminoSessaoExistente.isBefore(inicioSessaoNova);
		
		if (sessaoNovaTerminaAntesDaExistente || sessaoExistenteTerminaAntesDaNova) {
			return false;
		}
		
		return true;
	}
	
	private boolean horarioIsConflitante_v2(Sessao sessaoExistente, Sessao sessaoNova) {
		
		// Sessao B
		LocalDateTime inicioSessaoExistente = getInicioSessaoComDiaDeHoje(sessaoExistente);
		LocalDateTime terminoSessaoExistente = getTerminoSessaoComDiaDeHoje(sessaoExistente);

		// Sessao A
		LocalDateTime inicioSessaoNova = getInicioSessaoComDiaDeHoje(sessaoNova);
		LocalDateTime terminoSessaoNova = getTerminoSessaoComDiaDeHoje(sessaoNova);
		
		// A.F > B.I
		if (terminoSessaoNova.isAfter(inicioSessaoExistente)) {
			return true;
		}
		
		// B.F > A.I
		if (terminoSessaoExistente.isAfter(inicioSessaoNova)) {
			return true;
		}
		
		return false;
	}


}

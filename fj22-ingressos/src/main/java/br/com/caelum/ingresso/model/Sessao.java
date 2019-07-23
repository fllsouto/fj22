package br.com.caelum.ingresso.model;

import java.time.LocalTime;

public class Sessao {

	private Long id;
	private LocalTime horario;
	private Sala sala;
	private Filme filme;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}

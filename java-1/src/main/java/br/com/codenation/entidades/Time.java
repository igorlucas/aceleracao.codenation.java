package br.com.codenation.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Time {

	private Long id;
	private Long idJogador;
	private String nome;
	private LocalDate dataCriacao;
	private String corUniformePrincipal;
	private String corUniformeSecundario;
	public List<Jogador> jogadores = new ArrayList<>();

	public Time(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {

		this.id = id;
		this.nome = nome;
		this.dataCriacao = dataCriacao;
		this.corUniformePrincipal = corUniformePrincipal;
		this.corUniformeSecundario = corUniformeSecundario;
	}

	public Time() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCorUniformePrincipal() {
		return corUniformePrincipal;
	}

	public void setCorUniformePrincipal(String corUniformePrincipal) {
		this.corUniformePrincipal = corUniformePrincipal;
	}

	public String getCorUniformeSecundario() {
		return corUniformeSecundario;
	}

	public void setCorUniformeSecundario(String corUniformeSecundario) {
		this.corUniformeSecundario = corUniformeSecundario;
	}

	public Long getIdJogador() {
		return idJogador;
	}

	public void setIdJogador(Long idJogador) {
		this.idJogador = idJogador;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

}

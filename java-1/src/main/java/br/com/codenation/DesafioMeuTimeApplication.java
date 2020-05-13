package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.entidades.Jogador;
import br.com.codenation.entidades.Time;
import br.com.codenation.repositorios.DesafioMeuTimeRepositorio;

public class DesafioMeuTimeApplication implements MeuTimeInterface {

	private DesafioMeuTimeRepositorio timeRepo = new DesafioMeuTimeRepositorio();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal,
			String corUniformeSecundario) {
		Time time = new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario);
		timeRepo.Add(time);
	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade,
			BigDecimal salario) {
		Jogador jogador = new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario);
		timeRepo.AddJogador(jogador);
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		timeRepo.definirCapitao(idJogador);
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		return timeRepo.BuscarCapitao(idTime);
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		return timeRepo.buscarNomeJogador(idJogador);
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		return timeRepo.buscarNomeTime(idTime);
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		return timeRepo.buscarJogadoresDoTime(idTime);
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		return timeRepo.buscarMelhorJogadorDoTime(idTime);
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		return timeRepo.buscarJogadorMaisVelho(idTime);
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		return timeRepo.buscarTimes();
	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		return timeRepo.buscarJogadorMaiorSalario(idTime);
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		return timeRepo.buscarSalarioDoJogador(idJogador);
	}

	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		return timeRepo.buscarTopJogadores(top);
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		return timeRepo.buscarCorCamisaTimeDeFora(timeDaCasa, timeDeFora);
	}

}

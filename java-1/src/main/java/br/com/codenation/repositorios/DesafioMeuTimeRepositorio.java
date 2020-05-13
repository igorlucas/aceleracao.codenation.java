package br.com.codenation.repositorios;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.entidades.Jogador;
import br.com.codenation.entidades.Time;

public class DesafioMeuTimeRepositorio {

	private Set<Time> Times = new HashSet<>();

	public void Add(Time time) {
		if (GetTime(time.getId()) != null)
			throw new IdentificadorUtilizadoException();
		else
			Times.add(time);
	};

	public void AddJogador(Jogador jogador) {
		Time timeExistente = GetTime(jogador.getIdTime());
		Jogador jogadorExistente = GetJogador(jogador.getId());

		if (timeExistente == null)
			throw new TimeNaoEncontradoException();
		if (jogadorExistente != null)
			throw new IdentificadorUtilizadoException();

		timeExistente.getJogadores().add(jogador);
	}

	public void definirCapitao(Long idJogador) {
		Jogador jogador = GetJogador(idJogador);
		if (jogador == null)
			throw new JogadorNaoEncontradoException();
		else {
			Time time = GetTime(jogador.getIdTime());
			time.setIdJogador(idJogador);
		}
	}

	public Long BuscarCapitao(Long idTime) {
		Time time = GetTime(idTime);
		if (time == null)
			throw new TimeNaoEncontradoException();

		if (time.getIdJogador() == null)
			throw new CapitaoNaoInformadoException();

		return time.getIdJogador();
	}

	public String buscarNomeJogador(Long idJogador) {
		Jogador jogador = GetJogador(idJogador);

		if (jogador == null)
			throw new JogadorNaoEncontradoException();

		return jogador.getNome();
	}

	public String buscarNomeTime(Long idTime) {
		Time time = GetTime(idTime);

		if (time == null)
			throw new TimeNaoEncontradoException();

		return time.getNome();
	}

	public List<Long> buscarJogadoresDoTime(Long idTime) {

		List<Long> ids = new ArrayList<>();

		Time time = GetTime(idTime);

		if (time == null)
			throw new TimeNaoEncontradoException();
		else {
			time.getJogadores().stream()
			.sorted(Comparator.comparing(Jogador::getId))
			.forEach(j -> ids.add(j.getId()));
			return ids;
		}

	}

	public Long buscarMelhorJogadorDoTime(Long idTime) {

		Time time = GetTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException();
		}

		else {
			Comparator<Jogador> compararPorNivel = Comparator.comparing(Jogador::getNivelHabilidade);

			Jogador melhorJogador = time.getJogadores().stream().max(compararPorNivel).get();

			return melhorJogador.getId();
		}
	}

	public Long buscarJogadorMaisVelho(Long idTime) {

		Time time = GetTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException();
		} else {
			Comparator<Jogador> compararPorIdade = Comparator.comparing(Jogador::getDataNascimento)
					.thenComparing(Jogador::getId);

			return time.getJogadores().stream().min(compararPorIdade).get().getId();
		}
	}

	public List<Long> buscarTimes() {

		List<Long> idTimes = new ArrayList<>();

		if (Times.size() == 0)
			return idTimes;

		Times.stream().forEach(t -> idTimes.add(t.getId()));

		return idTimes;
	}

	public Long buscarJogadorMaiorSalario(Long idTime) {

		Time time = GetTime(idTime);

		if (time == null) {
			throw new TimeNaoEncontradoException();
		}

		else {
			Comparator<Jogador> comparadorPorSalario = Comparator.comparing(Jogador::getSalario).reversed()
					.thenComparing(Jogador::getId);

			List<Jogador> listJogadores = time.getJogadores().stream().sorted(comparadorPorSalario)
					.collect(Collectors.toList());

			return listJogadores.get(0).getId();

		}

	}

	public BigDecimal buscarSalarioDoJogador(Long idJogador) {

		Jogador jogador = GetJogador(idJogador);

		if (jogador != null)
			return jogador.getSalario();
		else
			throw new JogadorNaoEncontradoException();

	}

	public List<Long> buscarTopJogadores(Integer top) {
		List<Jogador> jogadores = new ArrayList<>();

		if (Times.isEmpty())
			throw new TimeNaoEncontradoException();

		Times.stream().forEach(t -> jogadores.addAll(t.getJogadores()));

		Comparator<Jogador> comparadorPorNivel = Comparator.comparing(Jogador::getNivelHabilidade).reversed()
				.thenComparing(Jogador::getId);

		return jogadores.stream().sorted(comparadorPorNivel).limit(top).map(j -> j.getId())
				.collect(Collectors.toList());

	}

	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {

		if (Times.size() == 0)
			throw new TimeNaoEncontradoException();

		if (timeDaCasa == null || timeDeFora == null)
			throw new TimeNaoEncontradoException();

		Optional<Time> time1 = Times.stream().filter(t -> t.getId().equals(timeDaCasa)).findAny();
		Optional<Time> time2 = Times.stream().filter(t -> t.getId().equals(timeDeFora)).findAny();

		if (time1.isPresent() && time2.isPresent()) {
			return time1.get().getCorUniformePrincipal() == time2.get().getCorUniformePrincipal()
					? time2.get().getCorUniformeSecundario()
					: time2.get().getCorUniformePrincipal();
		} else {
			throw new TimeNaoEncontradoException();
		}

	}

	public Time GetTime(long idTime) {
		Optional<Time> time = Times.stream().filter(x -> x.getId().equals(idTime)).findAny();

		if (time.isPresent())
			return time.get();
		else
			return null;
	};

	public Jogador GetJogador(Long idJogador) {
		Optional<Time> time = Times.stream()
				.filter(t -> 
				t.getJogadores().stream()
				.anyMatch(j -> j.getId().equals(idJogador)))
				.findAny();

		if (time.isPresent())
			return time.get().getJogadores().stream().filter(j -> j.getId().equals(idJogador)).findFirst().get();
		else
			return null;
	}

}

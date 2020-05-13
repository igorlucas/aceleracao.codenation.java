package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	private static Integer limiteVagas = 10;

	private List<Carro> carros = new ArrayList<>();

	public void estacionar(Carro carro) {
		ValidaMotorista(carro);
		if (NaoTemVaga())
			processoAddAlternativo(carros, carro);
		else
			carros.add(carro);
	}

	private boolean NaoTemVaga() {
		return (carrosEstacionados() + 1 > Estacionamento.limiteVagas);
	}

	private static void processoAddAlternativo(List<Carro> listaCarros, Carro carro) {
		boolean podeAdd = false;

		for (int i = 0; !podeAdd; i++) {
			
			if (i == limiteVagas)
				throw new EstacionamentoException("");
			
			else if (primeiroMotoristaTem55Anos(listaCarros, i)) {
				listaCarros.remove(i);
				listaCarros.add(carro);
				podeAdd = true;
			}
		}
	}

	private static boolean primeiroMotoristaTem55Anos(List<Carro> listaCarros, Integer index) {
		return listaCarros.get(index).getMotorista().getIdade() <= 55;
	}

	public int carrosEstacionados() {
		return carros.size();
	}

	public boolean carroEstacionado(Carro carro) {
		return carros.contains(carro);
	}

	private void ValidaMotorista(Carro carro) {
		if (carro.getMotorista() == null || carro.getMotorista().getIdade() < 18
				|| carro.getMotorista().getPontos() > 20)
			throw new EstacionamentoException("");
	}
}
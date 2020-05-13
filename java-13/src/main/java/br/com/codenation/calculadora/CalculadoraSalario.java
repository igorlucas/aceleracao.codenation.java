package br.com.codenation.calculadora;

public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		// Use o Math.round apenas no final do método para arredondar o valor final.
		// Documentação do método:
		// https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html#round-double-

		// se sm 1.039,00 - retornar 0
		if (salarioBase < 1039) {
			return 0;
		}
		
		double descontoINSS = calcularInss(salarioBase);

		double salarioBruto = salarioBase - descontoINSS;

		double descontoIRRF = calcularIrrf(salarioBruto);

		return Math.round(salarioBruto - descontoIRRF);
	}

	// Exemplo de método que pode ser criado para separar melhor as
	// responsábilidades de seu algorítmo
	private double calcularInss(double salarioBase) {
		double descontoINSS = 0;

		if (salarioBase <= 1500) {
			descontoINSS = salarioBase * 0.08;
		} else if (salarioBase <= 4000) {
			descontoINSS = salarioBase * 0.09;
		} else {
			descontoINSS = salarioBase * 0.11;
		}

		return descontoINSS;
	}

	private double calcularIrrf(double salarioBruto) {
		double descontoIRRF;

		if (salarioBruto <= 3000) {
			descontoIRRF = 0;
		} else if (salarioBruto <= 6000) {
			descontoIRRF = salarioBruto * 0.075;
		} else {
			descontoIRRF = salarioBruto * 0.15;
		}

		return descontoIRRF;
	}

}
/*
 * Dúvidas ou Problemas? Manda e-mail para o meajuda@codenation.dev que iremos
 * te ajudar!
 */
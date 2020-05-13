package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int soma = 0;
		for (int e : elements)
			soma += e;
		return (soma / elements.length);
	}

	public static int mode(int[] elements) {
		Arrays.sort(elements);
		int maiorRepeticoes = 0;
		int moda = 0;

		for (int a : elements) {
			int repeticoes = 0;

			for (int b : elements) {
				if (a == b)
					repeticoes++;

				if (repeticoes > maiorRepeticoes) {
					moda = a;
					maiorRepeticoes = repeticoes;
				}
			}
		}

		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int mediana = 0;
		if(elements.length%2 != 0) {
			int index = ((elements.length-1)/2);
			mediana = elements[index];
		}else {
			int a = elements[(elements.length/2)-1];
			int b = elements[(elements.length/2)];
			mediana = (a+b)/2;
		}
		return mediana;
	}
}
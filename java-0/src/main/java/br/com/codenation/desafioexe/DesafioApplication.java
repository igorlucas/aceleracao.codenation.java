package br.com.codenation.desafioexe;

import java.util.ArrayList;
import java.util.List;

public class DesafioApplication {

	public static List<Integer> fibonacci() {
		List<Integer> lista = new ArrayList<Integer>();
		int pre=0, pro=0, atual=0;
        for (int i=0; i<15; i++)
        {
            atual = pre + pro;
            lista.add(atual);
            if (pre == 0)
               pre = 1;
            else if (i > 1)
            {
                pro = pre;
                pre = atual;
            }
        }
		return lista;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> lista = fibonacci();
		return lista.contains(a);
	}
}
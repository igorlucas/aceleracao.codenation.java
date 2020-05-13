package challenge;

public class CriptografiaCesariana implements Criptografia {

	@Override
	public String criptografar(String texto) {

		ValidaTexto(texto);

		StringBuilder textoEncriptado = new StringBuilder();

		for (int i = 0; i < texto.length(); i++){  
			char t = texto.charAt(i);
			if (t == ' ' || Character.isDigit(t))
				textoEncriptado.append(t);
			else {
				int codePoint = Character.codePointAt(""+t, 0);
				switch (codePoint) {
				case 88:
				case 120:
				case 89:
				case 121:
				case 90:
				case 122:
					codePoint += -23;
					break;
				default:
					codePoint += 3;
					break;
				}
				textoEncriptado.append((char) codePoint);
			}

		}
		return textoEncriptado.toString().toLowerCase();
	}

	@Override
	public String descriptografar(String texto) {

		ValidaTexto(texto);
		
		StringBuilder textoDecifrado = new StringBuilder();

		for (int i = 0; i < texto.length(); i++){  
			char t = texto.charAt(i);
			if (t == ' ' || Character.isDigit(t))
				textoDecifrado.append(t);
			else {
				int codePoint = Character.codePointAt(""+t, 0);
				switch (codePoint) {
				case 97:
				case 98:
				case 99:
				case 65:
				case 66:
				case 67:
					codePoint += 23;
					break;
				default:
					codePoint += -3;
					break;
				}
				textoDecifrado.append((char) codePoint);
			}
		}
		return textoDecifrado.toString().toLowerCase();
	}
	
	static void ValidaTexto(String texto) {
		if (texto.isEmpty()) {
			throw new IllegalArgumentException();
		}
		else if (texto == null) {
			throw new NullPointerException();
		}
	}
}
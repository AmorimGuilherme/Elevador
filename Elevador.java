package br.com.brq.inicio.exercicios.elevador;

public class Elevador {

	private Integer[] andar;
	private Integer[] pessoa;
	private int numeroElevador;
	private int contadorAndar;
	private int contadorPessoa;

	public Elevador() {
		this.andar = new Integer[16];
		this.pessoa = new Integer[6];
		this.numeroElevador = 0;
		this.contadorAndar = 1;
		this.contadorPessoa = 1;
	}

	public Integer[] getAndar() {
		return andar;
	}

	public void setAndar(Integer[] andar) {
		this.andar = andar;
	}

	public Integer[] getPessoa() {
		return pessoa;
	}

	public void setPessoa(Integer[] pessoa) {
		this.pessoa = pessoa;
	}

	public int getNumeroElevador() {
		return numeroElevador;
	}

	public void setNumeroElevador(int numeroElevador) {
		this.numeroElevador = numeroElevador;
	}

	public int getContadorAndar() {
		return contadorAndar;
	}

	public void setContadorAndar(int contadorAndar) {
		this.contadorAndar = contadorAndar;
	}

	public int getContadorPessoa() {
		return contadorPessoa;
	}

	public void setContadorPessoa(int contadorPessoa) {
		this.contadorPessoa = contadorPessoa;
	}

}

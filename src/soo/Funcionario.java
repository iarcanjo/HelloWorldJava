package soo;

public class Funcionario {

	private String nome;

	private int matricula;

	private boolean ativo;

	protected String getNome() {
		return nome;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected int getMatricula() {
		return matricula;
	}

	protected void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	protected boolean isAtivo() {
		return ativo;
	}

	protected void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}

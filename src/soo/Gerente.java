package soo;

public class Gerente extends Funcionario {

	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public String getNome() {
		return super.getNome();
	}

}

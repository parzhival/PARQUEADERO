package com.krakedev.parqueadero.modelo;

public class Auto extends Vehiculo {

	private int numPuertas;

	public Auto(String placa, String propietario, int numpuertas) {

		super(placa, propietario);
		this.numPuertas = numpuertas;
	}

	public int getNumPuertas() {
		return numPuertas;
	}

	public void setNumPuertas(int numPuertas) {
		this.numPuertas = numPuertas;
	}

	@Override
	public double calcularTarifa(int horasPermanencia) {

		double total = horasPermanencia * 1.5;

		if (horasPermanencia > 4) {
			total = total + 2;
		}
		return total;
	}

	@Override
	public String toString() {
		return "Auto{" + "placa='" + getPlaca() + '\'' + ", propietario='" + getPropietario() + '\'' + ", horaIngreso="
				+ getHoraIngreso() + ", numeroPuertas=" + numPuertas + '}';
	}

}

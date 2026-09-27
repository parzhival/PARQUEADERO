package com.krakedev.parqueadero.servicios;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.krakedev.parqueadero.modelo.Vehiculo;

@Service
public class ServicioVehiculos {
	
	public class ServicioVehiculos {

		private ArrayList<Vehiculo> parqueadero = new ArrayList<>();

		private final int CAPACIDAD_MAXIMA = 10;

		public Vehiculo buscarPorPlaca(String placa) {
			for (Vehiculo vehiculo : parqueadero) {
				if (vehiculo.getPlaca().equals(placa)) {
					return vehiculo;
				}
			}
			return null;
		}

		public boolean ingresarVehiculo(Vehiculo vehiculo) {
			if (parqueadero.size() >= CAPACIDAD_MAXIMA) {
				return false;
			}
			if (buscarPorPlaca(vehiculo.getPlaca()) != null) {
				return false;
			}
			parqueadero.add(vehiculo);
			return true;
		}

		public Vehiculo retirarVehiculo(String placa) {
			Vehiculo vehiculo = buscarPorPlaca(placa);

			if (vehiculo != null) {
				parqueadero.remove(vehiculo);
				return vehiculo;
			}
			return null;
		}

		public ArrayList<Vehiculo> listarVehiculos() {
			return parqueadero;
		}

	}
}

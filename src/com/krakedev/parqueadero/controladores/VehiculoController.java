package com.krakedev.parqueadero.controladores;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.krakedev.parqueadero.modelo.Auto;
import com.krakedev.parqueadero.modelo.Motocicleta;
import com.krakedev.parqueadero.modelo.Vehiculo;
import com.krakedev.parqueadero.servicios.ServicioVehiculos;

@RestController

@RequestMapping("/vehiculos")
public class VehiculoController {
	private final ServicioVehiculos servicioVehiculos;

	public VehiculoController(ServicioVehiculos servicioVehiculos) {
		this.servicioVehiculos = servicioVehiculos;
	}

	@PostMapping("/auto")
	public ResponseEntity<?> ingresarAuto(@RequestBody Auto auto) {

		boolean agregado = servicioVehiculos.ingresarVehiculo(auto);
		if (agregado) {
			return ResponseEntity.status(HttpStatus.CREATED).body(auto);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT)
				.body("No se pudo ingresar el auto. La placa puede estar duplicada o el parqueadero está lleno.");
	}

	@PostMapping("/moto")
	public ResponseEntity<?> ingresarMoto(@RequestBody Motocicleta moto) {

		boolean agregado = servicioVehiculos.ingresarVehiculo(moto);
		if (agregado) {
			return ResponseEntity.status(HttpStatus.CREATED).body(moto);
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body(
				"No se pudo ingresar la motocicleta. La placa puede estar duplicada o el parqueadero está lleno.");
	}

	@GetMapping
	public ArrayList<Vehiculo> listarVehiculos() {

		return servicioVehiculos.listarVehiculos();
	}

	@GetMapping("/{placa}")
	public ResponseEntity<?> buscarPorPlaca(@PathVariable String placa) {

		Vehiculo vehiculo = servicioVehiculos.buscarPorPlaca(placa);
		if (vehiculo != null) {
			return ResponseEntity.ok(vehiculo);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un vehículo con la placa: " + placa);

	}

}

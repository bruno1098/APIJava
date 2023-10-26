package br.com.fiap.carrosapi.data;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.carrosapi.model.Carro;

public class CarrosDao {
	
	List<Carro> carros = new ArrayList<>();
	
	public CarrosDao() {
		carros = List.of(
				new Carro(1, "Fit", "Honda", 9.5),
				new Carro(2, "Civic", "Honda", 5.3),
				new Carro(3, "Jetta", "VolsWagem", 2.0)
			);
	}

	public List<Carro> findAll() {
		return carros;
	}
	
	public Carro findById(Long id) {
		
		return carros
				.stream()
				.filter(carro -> carro.id() == id)
				.findFirst()
				.orElse(null);
	}

}

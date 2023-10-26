package service;

import java.util.List;

import br.com.fiap.carrosapi.data.CarrosDao;
import br.com.fiap.carrosapi.model.Carro;

public class CarroService {
	
	private CarrosDao dao = new CarrosDao();

	public List<Carro> findAll() {
		return dao.findAll();
	}

	public Carro findById(Long id) {
		return dao.findById(id);
	}

	public void delete(Carro carro) {
		
	}
	
	public boolean save(Carro carro) {
		if (carro.id() == 0) return false;
		if (carro.nome().length() < 2)return false;
		if (carro.marca().length() < 3)return false;
		if (carro.nota() < 0 || carro.nota() > 10) return false;
			return true;
}

	public boolean update(Carro carro) {
		// TODO Auto-generated method stub
		return false;
	}
}

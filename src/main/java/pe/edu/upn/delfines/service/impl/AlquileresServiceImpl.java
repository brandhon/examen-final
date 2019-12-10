package pe.edu.upn.delfines.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.services.AlquilerService;

@Service
public class AlquileresServiceImpl implements AlquilerService{
	
	@Autowired
	private AlquilerRepository alquilerRepository;

	@Transactional
	@Override
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}
	
	@Transactional
	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(id);
	}

	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		alquilerRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		alquilerRepository.deleteAll();
		
	}

}

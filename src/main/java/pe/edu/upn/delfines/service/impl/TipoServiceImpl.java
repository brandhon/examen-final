package pe.edu.upn.delfines.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.services.TipoService;


@Service
public class TipoServiceImpl implements TipoService {
	
	@Autowired
	private TipoRepository tipoRepository;

	@Transactional
	@Override
	public List<Tipo> findAll() throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.findAll();
	}
	@Transactional
	@Override
	public Optional<Tipo> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.findById(id);
	}

	@Override
	public Tipo save(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Override
	public Tipo update(Tipo entity) throws Exception {
		// TODO Auto-generated method stub
		return tipoRepository.save(entity);
	}

	@Override
	public void deleteById(String id) throws Exception {
		tipoRepository.deleteById(id);
		
	}

	@Override
	public void deleteAll() throws Exception {
		tipoRepository.deleteAll();
		
	}
	

}

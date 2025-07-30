package es.cic._5.proy009.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic._5.proy009.model.Arbol;
import es.cic._5.proy009.model.Rama;
import es.cic._5.proy009.repository.ArbolRepository;

@Service
@Transactional
public class ArbolService {

    @Autowired
    private ArbolRepository arbolRepository;

    public Arbol create(Arbol arbol) {

        return arbolRepository.save(arbol);
    }

    public Arbol createRama (Rama rama) {
        return arbolRepository.save(rama);
    }

    @Transactional(readOnly = true)
    public List<Arbol> get() {
        return arbolRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Arbol get(Long id) {
        Optional<Arbol> arbol = arbolRepository.findById(id);
        return arbol.orElse(null);
    }

    public void update(Arbol conductor) {
        arbolRepository.save(conductor);
    }

    public void delete(Long id) {
        arbolRepository.deleteById(id);
    }
}

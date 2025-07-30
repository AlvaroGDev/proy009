package es.cic._5.proy009.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic._5.proy009.model.Arbol;
import es.cic._5.proy009.model.Rama;
import es.cic._5.proy009.repository.ArbolRepository;
import es.cic._5.proy009.repository.RamaRepository;

@Service
@Transactional
public class ArbolService {

    @Autowired
    private ArbolRepository arbolRepository;

    @Autowired
    private RamaRepository ramaRepository;

    public Arbol create(Arbol arbol) {
        return arbolRepository.save(arbol);
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

    public void update(Arbol arbol) {
        arbolRepository.save(arbol);
    }

    public void delete(Long id) {
        arbolRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Rama getRama(Long id) {
        Optional<Rama> rama = ramaRepository.findById(id);
        return rama.orElse(null);
    }

    public Rama saveRama(Rama rama){
            
       return ramaRepository.save(rama);
    }

    public void deleteRama(Rama rama) {
        ramaRepository.delete(rama);
    }

    public Rama updateRama(Rama rama) {
        return ramaRepository.save(rama);
    }
}

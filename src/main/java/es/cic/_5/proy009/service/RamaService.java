package es.cic._5.proy009.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import es.cic._5.proy009.model.Rama;
import es.cic._5.proy009.repository.RamaRepository;

@Service
@Transactional
public class RamaService {

    @Autowired
    private RamaRepository ramaRepository;

    public Rama create(Rama rama) {
        return ramaRepository.save(rama);
    }

    @Transactional(readOnly = true)
    public List<Rama> get() {
        return ramaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Rama get(Long id) {
        Optional<Rama> rama = ramaRepository.findById(id);
        return rama.orElse(null);
    }

    public void update(Rama rama) {
        ramaRepository.save(rama);
    }

    public void delete(Long id) {
        ramaRepository.deleteById(id);
    }
}

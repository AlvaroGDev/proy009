package es.cic._5.proy009.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic._5.proy009.model.Arbol;
import es.cic._5.proy009.service.ArbolService;

@RestController
@RequestMapping("/arbol")
public class ArbolController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArbolController.class);
    
    @Autowired
    private ArbolService arbolService;

    @GetMapping
    public List<Arbol> getAll() {
        LOGGER.info("Leo todos los árboles");
        return arbolService.get();
    }

    @GetMapping("/{id}")
    public Arbol get(@PathVariable Long id) {
        LOGGER.info("Leo el árbol con id: " + id);
        if (arbolService.get(id) == null)
            throw new SecurityException("Error: me estás intentando crear un registro mediante lectura");

        return arbolService.get(id);
    }

    @PostMapping
    public Arbol create(@RequestBody Arbol arbol) {
        LOGGER.info("Creo un árbol");
        if (arbol.getId() != null)
            throw new SecurityException("Error: no me puedes mandar un id al crear");

        return arbolService.create(arbol);
    }

    @PutMapping
    public void update(@RequestBody Arbol arbol) {
        LOGGER.info("Modifico un arbol");
        if (arbol.getId() == null)
            throw new SecurityException(
                    "O te ha faltado el ID, o has intentado crear un registro mediante modificación.");

        arbolService.update(arbol);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) Long id) {
        LOGGER.info("Borro el árbol con id: " + id);
        arbolService.delete(id);
    }

}

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

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic._5.proy009.model.Accion;
import es.cic._5.proy009.model.Arbol;
import es.cic._5.proy009.model.Rama;
import es.cic._5.proy009.model.RamaDTO;
import es.cic._5.proy009.service.ArbolService;

@RestController
@RequestMapping("/arbol")
public class ArbolController {

    private final static Logger LOGGER = LoggerFactory.getLogger(ArbolController.class);

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    private ArbolService arbolService;


    // -- MÉTODOS CRUD PARA ÁRBOL --

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

    // -- MÉTODOS CRUD PARA RAMA --
    @PostMapping("/{id}/rama") // El arbol desarrolla una rama
    public Rama createRama(@PathVariable Long id, @RequestBody Rama rama) throws Exception {
        // Le tengo que pasar un id de árbol y una rama
        Arbol arbol = arbolService.get(id); // Me cojo el id (o el nulo si no existe)

        if (arbol == null)
            throw new Exception("Error: Estás apuntando a un arbol que no existe");
        // Si no existe tiro excepción directamente
        rama.setArbol(arbol);
        // Si existe, se lo añado a la rama
        return arbolService.saveRama(rama);
        // Guardo esa rama dentro del árbol
    }

    @PostMapping("/{id}/acciones")
    public void ejecutaAcciones(@PathVariable Long id, @RequestBody List<Accion> acciones) throws Exception {

        Long idArbolActual = arbolService.get(id).getId(); // Devuelve un arbol o un nulo
        Rama miRama;

        for (Accion accion : acciones) {

            miRama = null; // 'Limpiamos' la rama para no llevarnos datos
            RamaDTO dataRama = accion.getDataRama(); // En dataRama tenemos los datos de la rama (de la clase RamaDTO)

            switch (accion.getTipoAccion()) { // Aquí entra en crear, borrar, actualizar

                case "CREAR":

                    if (idArbolActual == null)
                        throw new CreateSecurityException("Error: no me puedes pasar un ID para crear"); // Si es nulo nos vamos

                    miRama = objectMapper.convertValue(dataRama, Rama.class); // Guardamos el objeto miRama
                    miRama.setArbol(arbolService.get(id)); // Le decimos a que arbol pertenece

                    arbolService.saveRama(miRama); // Guardamos utilizando el arbolService

                    break;

                case "BORRAR":

                    Long idABorrar = dataRama.getId();
                    Rama ramaABorrar = arbolService.getRama(idABorrar);

                    if(ramaABorrar == null)
                         throw new DeleteSecurityException("Error: no se encuentra la rama");
                        // Como en este caso el borrado se hace pasando una rama entera, lo controlamos
                    

                        
                    miRama = objectMapper.convertValue(dataRama, Rama.class);
                    miRama.setArbol(arbolService.get(idABorrar));
                    // Creo un objeto rama y le cojo el id
                    arbolService.deleteRama(miRama); // Para borrar la rama sí le pasamos la rama entera, no solo el id

                    break;

                case "ACTUALIZAR":

                    miRama = objectMapper.convertValue(dataRama, Rama.class);
                    if(miRama.getId() == null)
                        throw new DeleteSecurityException("Error: me estás intentando crear un registro mediante modificación");

                    miRama.setArbol(arbolService.get(id));

                    arbolService.updateRama(miRama);

                    break; 

                default:
                throw new Exception("Error: has indicado una acción que no existe.");
                   
            }

        }
    }

}

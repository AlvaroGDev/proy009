package es.cic._5.proy009;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.cic._5.proy009.model.Arbol;
import es.cic._5.proy009.model.Rama;

import es.cic._5.proy009.service.ArbolService;

@Component
public class CargaDeDatos implements CommandLineRunner {

    @Autowired
    private ArbolService arbolService;

    @Override
    public void run(String... datos) {

        Arbol roble = new Arbol();
        roble.setEdad(80L); // L por Long
        roble.setEspecie("roble");
        roble.setTipoHoja("Perenne");
        roble.setFrutal(true);

        Arbol manzano = new Arbol();
        manzano.setEdad(30L);
        manzano.setEspecie("Manzano");
        manzano.setTipoHoja("Caduca");
        manzano.setFrutal(true);

        arbolService.create(roble);
        arbolService.create(manzano);

        // Crear ramas
        Rama rama1 = new Rama();
        rama1.setNumHojas(150); // int no necesita conversión
        rama1.setTorcida(false);
        rama1.setLongitud(197L);
        rama1.setGrosor(15L);
        rama1.setArbol(roble);

        Rama rama2 = new Rama();
        rama2.setNumHojas(87);
        rama2.setTorcida(false);
        rama2.setLongitud(200L);
        rama2.setGrosor(34L);
        rama2.setArbol(roble);

        arbolService.saveRama(rama1);
        arbolService.saveRama(rama2);

        // Roble tiene 2 ramas

        Rama ramaManzano3 = new Rama();
        ramaManzano3.setNumHojas(45);
        ramaManzano3.setTorcida(false);
        ramaManzano3.setLongitud(90L);
        ramaManzano3.setGrosor(5L);
        ramaManzano3.setArbol(manzano);

        Rama ramaManzano4 = new Rama();
        ramaManzano4.setNumHojas(30);
        ramaManzano4.setTorcida(true);
        ramaManzano4.setLongitud(60L);
        ramaManzano4.setGrosor(3L);
        ramaManzano4.setArbol(manzano);

        arbolService.saveRama(ramaManzano3);
        arbolService.saveRama(ramaManzano4);

        //Manzano tiene dos ramas

    }

}

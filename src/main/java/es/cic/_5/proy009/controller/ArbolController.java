package es.cic._5.proy009.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic._5.proy009.model.Arbol;
import es.cic._5.proy009.repository.ArbolRepository;
import es.cic._5.proy009.service.ArbolService;

@RestController
@RequestMapping("/arbol")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @Autowired
    private ArbolRepository arbolRepository;

    @GetMapping
    public List<Arbol>getAll(){
        return arbolService.get();
    }

    
}

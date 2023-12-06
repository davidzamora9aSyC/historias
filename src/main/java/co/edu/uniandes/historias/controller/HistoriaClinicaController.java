package co.edu.uniandes.historias.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import co.edu.uniandes.historias.model.HistoriaClinica;
import  co.edu.uniandes.historias.repository.HistoriaClinicaRepository;

import java.util.List;
import java.util.Optional;

@Controller
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaRepository historiaClinicaRepository;


    @GetMapping("/historias")
    public String reada(Model model) {
        model.addAttribute("historias", historiaClinicaRepository.findAll());
        return "historias";
    }
    
}

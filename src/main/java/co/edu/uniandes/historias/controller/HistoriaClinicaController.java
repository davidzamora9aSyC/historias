package co.edu.uniandes.historias.controller;

import org.springframework.ui.Model;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import co.edu.uniandes.historias.model.Orden;
import co.edu.uniandes.historias.model.HistoriaClinica;
import co.edu.uniandes.historias.model.Orden;
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

    @GetMapping("/historias/{historiaId}/ordenes")
    public String obtenerOrdenesDeHistoria(@PathVariable String historiaId, Model model) {



        Optional<HistoriaClinica> historiaOptional = historiaClinicaRepository.findById(historiaId);
        HistoriaClinica historia = historiaOptional.orElse(null);

        model.addAttribute("ordenes", historia.getOrdenes());
        model.addAttribute("idHistoria", historiaId);
        return "ordenes"; 
    }



    @GetMapping("/historias/{historiaId}/ordenes/{ordenId}/delete")
    public String delete(@PathVariable String historiaId, @PathVariable String ordenId) {
        HistoriaClinica historia = historiaClinicaRepository.findById(historiaId).orElse(null);

        if (historia != null) {
            List<Orden> ordenes = historia.getOrdenes();
            ordenes.removeIf(orden -> orden.getId().equals(new ObjectId(ordenId)));
            historiaClinicaRepository.save(historia);
        }

        return "redirect:/historias/{historiaId}/ordenes";
    }

    @GetMapping("/historias/{historiaId}/ordenes/new")
    public String createOrden(@PathVariable String historiaId, Model model) {
        model.addAttribute("orden", new Orden());
        model.addAttribute("historiaId", historiaId); 
        return "ordenesNew";
    }

    @PostMapping("/historias/{historiaId}/ordenes/new/save")
    public String ordenCreateSave(@ModelAttribute Orden orden , @PathVariable String historiaId) {
        historiaClinicaRepository.insertOrden(historiaId, orden);
        return "redirect:/historias/{historiaId}/ordenes";
    }


    
}

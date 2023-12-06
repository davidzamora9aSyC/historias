package co.edu.uniandes.historias.repository;

import java.util.List;

import org.bson.types.ObjectId;

import co.edu.uniandes.historias.model.HistoriaClinica;
import co.edu.uniandes.historias.model.Orden;

public interface HistoriaClinicaRepositoryCustom {
    
    HistoriaClinica insertOrden(String historiaId, Orden orden);
}

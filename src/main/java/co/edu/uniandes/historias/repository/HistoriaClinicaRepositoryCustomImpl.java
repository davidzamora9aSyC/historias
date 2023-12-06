package co.edu.uniandes.historias.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.edu.uniandes.historias.model.HistoriaClinica;
import co.edu.uniandes.historias.model.Orden;

@Repository
public class HistoriaClinicaRepositoryCustomImpl implements HistoriaClinicaRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;
    
    @Override
    public HistoriaClinica insertOrden(String historiaId, Orden orden) {

        Query query = new Query(Criteria.where("_id").is(historiaId));
        HistoriaClinica historia = mongoTemplate.findOne(query, HistoriaClinica.class);
        orden.setIdCustom();
        if (historia != null) {
            List<Orden> ordenes = historia.getOrdenes();
            ordenes.add(orden);
            historia.setOrdenes(ordenes);

            return mongoTemplate.save(historia);
        }
        return null;
    }
}
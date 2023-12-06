package co.edu.uniandes.historias.model;

import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("hello")
public class Hello {

    @Id
    private ObjectId _id;
    private String name;
    private int edad;

    public Hello() {
    }

    public Hello(String name, int edad) {
        
        this.name = name;
        this.edad = edad;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    

}

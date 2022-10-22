
package com.portfolio.nm.Interface;

import com.portfolio.nm.Entity.Persona;
import java.util.List;


public interface IPersonaService {
    //Treaer una persona
    public List<Persona> getPersona();
    
    //guardar
    public void savePersona(Persona persona);
    
    //Eliminar
    public void deletePersona(Long id);
    
    //Buscar
    public Persona findPersona(Long id);
}

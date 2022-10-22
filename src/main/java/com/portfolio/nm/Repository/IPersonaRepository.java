
package com.portfolio.nm.Repository;

import com.portfolio.nm.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonaRepository extends JpaRepository<Persona,Long>{
    
}

package co.edu.unbosque.service.implem;

import co.edu.unbosque.entity.Auditoria;
import co.edu.unbosque.repository.AuditoriaRepository;
import co.edu.unbosque.service.api.AuditoriaServiceAPI;
import co.edu.unbosque.util.GenericServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AuditoriaServiceImplement extends GenericServiceImplement<Auditoria, Long> implements AuditoriaServiceAPI {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    @Override
    public CrudRepository<Auditoria, Long> getDao() {
        return auditoriaRepository;
    }
}
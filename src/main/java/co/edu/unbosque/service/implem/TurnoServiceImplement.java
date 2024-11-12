package co.edu.unbosque.service.implem;

import co.edu.unbosque.entity.Turno;
import co.edu.unbosque.repository.TurnoRepository;
import co.edu.unbosque.service.api.TurnoServiceAPI;
import co.edu.unbosque.util.GenericServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TurnoServiceImplement extends GenericServiceImplement<Turno, Long> implements TurnoServiceAPI {

    @Autowired
    private TurnoRepository turnoRepository;

    @Override
    public CrudRepository<Turno, Long> getDao() {
        return turnoRepository;
    }
}

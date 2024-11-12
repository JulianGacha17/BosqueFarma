package co.edu.unbosque.service.implem;

import co.edu.unbosque.entity.Expendio;
import co.edu.unbosque.repository.ExpendioRepository;
import co.edu.unbosque.service.api.ExpendioServiceAPI;
import co.edu.unbosque.util.GenericServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ExpendioServiceImplement extends GenericServiceImplement<Expendio, Long> implements ExpendioServiceAPI {

    @Autowired
    private ExpendioRepository expendioRepository;

    @Override
    public CrudRepository<Expendio, Long> getDao() {
        return expendioRepository;
    }
}

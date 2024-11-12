package co.edu.unbosque.service.implem;

import co.edu.unbosque.entity.Medicamento;
import co.edu.unbosque.repository.MedicamentoRepository;
import co.edu.unbosque.service.api.MedicamentoServiceAPI;
import co.edu.unbosque.util.GenericServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoServiceImplement extends GenericServiceImplement<Medicamento, Long> implements MedicamentoServiceAPI {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public CrudRepository<Medicamento, Long> getDao() {
        return medicamentoRepository;
    }
}

package co.edu.unbosque.service.implem;

import co.edu.unbosque.entity.Inventario;
import co.edu.unbosque.repository.InventarioRepository;
import co.edu.unbosque.service.api.InventarioServiceAPI;
import co.edu.unbosque.util.GenericServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImplement extends GenericServiceImplement<Inventario, Long> implements InventarioServiceAPI {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public CrudRepository<Inventario, Long> getDao() {
        return inventarioRepository;
    }
}

package co.edu.unbosque.service.implem;

import co.edu.unbosque.entity.TipoUsuario;
import co.edu.unbosque.repository.TipoUsuarioRepository;
import co.edu.unbosque.service.api.TipoUsuarioServiceAPI;
import co.edu.unbosque.util.GenericServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioServiceImplement extends GenericServiceImplement<TipoUsuario, Short> implements TipoUsuarioServiceAPI {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public CrudRepository<TipoUsuario, Short> getDao() {
        return tipoUsuarioRepository;
    }
}

package co.edu.unbosque.controller;

import co.edu.unbosque.entity.TipoUsuario;
import co.edu.unbosque.service.api.TipoUsuarioServiceAPI;
import co.edu.unbosque.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioServiceAPI tipoUsuarioServiceAPI;

    @GetMapping(value = "/getAll")
    public List<TipoUsuario> getAll() {
        return tipoUsuarioServiceAPI.getAll();
    }

    @PostMapping(value = "/saveTipoUsuario")
    public ResponseEntity<TipoUsuario> save(@RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario obj = tipoUsuarioServiceAPI.save(tipoUsuario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<TipoUsuario> getTipoUsuarioById(@PathVariable Short id)
            throws ResourceNotFoundException {
        TipoUsuario tipoUsuario = tipoUsuarioServiceAPI.get(id);
        if (tipoUsuario == null) {
            throw new ResourceNotFoundException("Record not found for <TipoUsuario> " + id);
        }
        return ResponseEntity.ok().body(tipoUsuario);
    }

    @DeleteMapping(value = "/deleteTipoUsuario/{id}")
    public ResponseEntity<TipoUsuario> delete(@PathVariable Short id) {
        TipoUsuario tipoUsuario = tipoUsuarioServiceAPI.get(id);
        if (tipoUsuario != null) {
            tipoUsuarioServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(tipoUsuario, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(tipoUsuario, HttpStatus.OK);
    }
}

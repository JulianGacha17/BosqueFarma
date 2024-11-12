package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Inventario;
import co.edu.unbosque.service.api.InventarioServiceAPI;
import co.edu.unbosque.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioServiceAPI inventarioServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Inventario> getAll() {
        return inventarioServiceAPI.getAll();
    }

    @PostMapping(value = "/saveInventario")
    public ResponseEntity<Inventario> save(@RequestBody Inventario inventario) {
        Inventario obj = inventarioServiceAPI.save(inventario);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Inventario> getInventarioById(@PathVariable Long id)
            throws ResourceNotFoundException {
        Inventario inventario = inventarioServiceAPI.get(id);
        if (inventario == null) {
            throw new ResourceNotFoundException("Record not found for <Inventario> " + id);
        }
        return ResponseEntity.ok().body(inventario);
    }

    @DeleteMapping(value = "/deleteInventario/{id}")
    public ResponseEntity<Inventario> delete(@PathVariable Long id) {
        Inventario inventario = inventarioServiceAPI.get(id);
        if (inventario != null) {
            inventarioServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(inventario, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(inventario, HttpStatus.OK);
    }
}

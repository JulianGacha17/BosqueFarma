package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Expendio;
import co.edu.unbosque.service.api.ExpendioServiceAPI;
import co.edu.unbosque.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expendio")
public class ExpendioController {

    @Autowired
    private ExpendioServiceAPI expendioServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Expendio> getAll() {
        return expendioServiceAPI.getAll();
    }

    @PostMapping(value = "/saveExpendio")
    public ResponseEntity<Expendio> save(@RequestBody Expendio expendio) {
        Expendio obj = expendioServiceAPI.save(expendio);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Expendio> getExpendioById(@PathVariable Long id)
            throws ResourceNotFoundException {
        Expendio expendio = expendioServiceAPI.get(id);
        if (expendio == null) {
            throw new ResourceNotFoundException("Record not found for <Expendio> " + id);
        }
        return ResponseEntity.ok().body(expendio);
    }

    @DeleteMapping(value = "/deleteExpendio/{id}")
    public ResponseEntity<Expendio> delete(@PathVariable Long id) {
        Expendio expendio = expendioServiceAPI.get(id);
        if (expendio != null) {
            expendioServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(expendio, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(expendio, HttpStatus.OK);
    }
}

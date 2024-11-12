package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Turno;
import co.edu.unbosque.service.api.TurnoServiceAPI;
import co.edu.unbosque.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turno")
public class TurnoController {

    @Autowired
    private TurnoServiceAPI turnoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Turno> getAll() {
        return turnoServiceAPI.getAll();
    }

    @PostMapping(value = "/saveTurno")
    public ResponseEntity<Turno> save(@RequestBody Turno turno) {
        Turno obj = turnoServiceAPI.save(turno);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Turno> getTurnoById(@PathVariable Long id)
            throws ResourceNotFoundException {
        Turno turno = turnoServiceAPI.get(id);
        if (turno == null) {
            throw new ResourceNotFoundException("Record not found for <Turno> " + id);
        }
        return ResponseEntity.ok().body(turno);
    }

    @DeleteMapping(value = "/deleteTurno/{id}")
    public ResponseEntity<Turno> delete(@PathVariable Long id) {
        Turno turno = turnoServiceAPI.get(id);
        if (turno != null) {
            turnoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(turno, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(turno, HttpStatus.OK);
    }
}

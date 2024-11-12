package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Medicamento;
import co.edu.unbosque.service.api.MedicamentoServiceAPI;
import co.edu.unbosque.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

    @Autowired
    private MedicamentoServiceAPI medicamentoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Medicamento> getAll() {
        return medicamentoServiceAPI.getAll();
    }

    @PostMapping(value = "/saveMedicamento")
    public ResponseEntity<Medicamento> save(@RequestBody Medicamento medicamento) {
        Medicamento obj = medicamentoServiceAPI.save(medicamento);
        return new ResponseEntity<>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Medicamento> getMedicamentoById(@PathVariable Long id)
            throws ResourceNotFoundException {
        Medicamento medicamento = medicamentoServiceAPI.get(id);
        if (medicamento == null) {
            throw new ResourceNotFoundException("Record not found for <Medicamento> " + id);
        }
        return ResponseEntity.ok().body(medicamento);
    }

    @DeleteMapping(value = "/deleteMedicamento/{id}")
    public ResponseEntity<Medicamento> delete(@PathVariable Long id) {
        Medicamento medicamento = medicamentoServiceAPI.get(id);
        if (medicamento != null) {
            medicamentoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<>(medicamento, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(medicamento, HttpStatus.OK);
    }
}

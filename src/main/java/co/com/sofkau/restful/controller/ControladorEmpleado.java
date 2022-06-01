package co.com.sofkau.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.sofkau.restful.dto.EmpleadoDTO;
import co.com.sofkau.restful.service.ServicioEmpleado;

@RestController
@RequestMapping("/empleados")
public class ControladorEmpleado {
    @Autowired
    ServicioEmpleado servicioEmpleado;

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoDTO> findbyId(@PathVariable("id") String id) {
        return new ResponseEntity(servicioEmpleado.obtenerPorId(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<EmpleadoDTO>> findAll() {
        return new ResponseEntity(servicioEmpleado.obtenerTodos(), HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<EmpleadoDTO> create(@RequestBody EmpleadoDTO empleadoDTO) {
        return new ResponseEntity(servicioEmpleado.crear(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/modificar")
    public ResponseEntity<EmpleadoDTO> update(@RequestBody EmpleadoDTO empleadoDTO) {
        if (empleadoDTO.getId() != null) {
            return new ResponseEntity(servicioEmpleado.modificar(empleadoDTO), HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        try {
            servicioEmpleado.borrar(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}

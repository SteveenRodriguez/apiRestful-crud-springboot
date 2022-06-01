package co.com.sofkau.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.sofkau.restful.dto.EmpleadoDTO;
import co.com.sofkau.restful.mapper.EmpleadoMapper;
import co.com.sofkau.restful.model.Empleado;
import co.com.sofkau.restful.repository.RepositorioEmpleado;

@Service
public class ServicioEmpleado {
    @Autowired
    RepositorioEmpleado repositorioEmpleado;
    EmpleadoMapper mapper = new EmpleadoMapper();

    public List<EmpleadoDTO> obtenerTodos() {
        List<Empleado> empleados = (List<Empleado>) repositorioEmpleado.findAll();
        return mapper.fromCollectionList(empleados);
    }

    public EmpleadoDTO obtenerPorId(String id) {
        Empleado empleado = repositorioEmpleado.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        return mapper.fromCollection(empleado);
    }

    public EmpleadoDTO crear(EmpleadoDTO empleadoDTO) {
        Empleado empleado = mapper.fromDTO(empleadoDTO);
        return mapper.fromCollection(repositorioEmpleado.save(empleado));
    }

    public EmpleadoDTO modificar(EmpleadoDTO empleadoDTO) {
        Empleado empleado = mapper.fromDTO(empleadoDTO);
        repositorioEmpleado.findById(empleado.getId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
        return mapper.fromCollection(repositorioEmpleado.save(empleado));
    }

    public void borrar(String id) {
        repositorioEmpleado.deleteById(id);
    }
}

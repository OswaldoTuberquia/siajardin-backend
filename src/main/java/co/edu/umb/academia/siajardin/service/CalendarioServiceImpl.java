package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.dto.CalendarioDTO;
import co.edu.umb.academia.siajardin.exceptions.CalendarioException;
import co.edu.umb.academia.siajardin.model.Calendario;
import co.edu.umb.academia.siajardin.repo.CalendarioJpaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalendarioServiceImpl implements CalendarioService {

    @Autowired
    private CalendarioJpaRepository repo;

    @Transactional(readOnly = true)
    @Override
    public List<CalendarioDTO> listarCalendarios() throws CalendarioException {
        List<CalendarioDTO> listaFinal = new ArrayList<>();
        List<Calendario> lista = repo.findAll();
        if (!lista.isEmpty()) {
            lista.forEach((calendario) -> {
                listaFinal.add(mapEntityToDto(calendario));
            });
        }
        return listaFinal;
    }

    @Override
    public CalendarioDTO mapEntityToDto(Calendario calendario) {
        return new CalendarioDTO(
                calendario.getId(),
                calendario.getDescripcion().trim(),
                calendario.getFecha_inicial().toString(),
                calendario.getFecha_final().toString(),
                ((calendario.getActivo() == 1) ? "Activo" : "Inactivo"));
    }

    @Transactional(readOnly = true)
    @Override
    public Calendario buscarEntidadPorId(long idCalendario) throws CalendarioException {
        return repo.findById(idCalendario).orElse(null);
    }

    @Transactional
    @Override
    public void guardarCalendario(Calendario calendario) throws CalendarioException {
        repo.saveAndFlush(calendario);
    }

}

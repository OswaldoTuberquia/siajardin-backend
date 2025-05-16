package co.edu.umb.academia.siajardin.service;

import co.edu.umb.academia.siajardin.dto.CalendarioDTO;
import co.edu.umb.academia.siajardin.exceptions.CalendarioException;
import co.edu.umb.academia.siajardin.model.Calendario;
import java.util.List;

public interface CalendarioService {

    public List<CalendarioDTO> listarCalendarios() throws CalendarioException;

    public CalendarioDTO mapEntityToDto(Calendario calendario);

    public Calendario buscarEntidadPorId(long idCalendario) throws CalendarioException;

    public void guardarCalendario(Calendario calendario) throws CalendarioException;
}

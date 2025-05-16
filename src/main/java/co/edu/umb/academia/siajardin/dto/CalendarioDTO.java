package co.edu.umb.academia.siajardin.dto;

public record CalendarioDTO(
        long secuencia, 
        String descripcion, 
        String fechainicial, 
        String fechafinal,
        String estado) {
    
}

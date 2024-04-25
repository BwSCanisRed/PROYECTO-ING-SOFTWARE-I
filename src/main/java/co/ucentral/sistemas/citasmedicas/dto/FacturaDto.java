package co.ucentral.sistemas.citasmedicas.dto;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FacturaDto {

    private int id_factura;
    private LocalDateTime fecha;
    private BigDecimal valor;
    private Boolean estado;
}

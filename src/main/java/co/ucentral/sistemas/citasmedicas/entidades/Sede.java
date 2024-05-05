    package co.ucentral.sistemas.citasmedicas.entidades;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import lombok.ToString;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor

    @Table(name = "Sedes")
    @ToString
    @Entity
    public class Sede {

        @Id
        @Column(name = "Sed_id", insertable = false, updatable = false)
        private int idSede;

        @Column(name = "Sed_descripcion", nullable = false)
        private String nombre;

        @Column(name = "Sed_direccion", nullable = true)
        private String direccion;

        @Column(name = "Sed_nconsultorios", nullable = false)
        private int nconsultorios;

    }
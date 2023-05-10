package Nexa.luishidalgoa.com.Nexa.Model.domain.publications;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Data
@Entity
@Table
public class Share {
    /**
     * Este campo hace ref erencia al usuario que difundio la publicacion
     */
    @Column(name = "user_name", nullable = false, length = 15)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String user_name;

    @Column(name = "id_publication")
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id_publication;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

}

package Nexa.luishidalgoa.com.Nexa.Model.domain.publications;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "likes")
public class likes {
    /**
     * Este campo hace referencia al usuario que le dio Like
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

    @Column(name = "date_like")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Timestamp date_like;

}

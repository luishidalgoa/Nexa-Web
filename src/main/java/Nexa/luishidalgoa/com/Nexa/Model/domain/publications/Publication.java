package Nexa.luishidalgoa.com.Nexa.Model.domain.publications;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.sql.Timestamp;

@Data
@Entity
@Table
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private Integer id;

    @Column(name = "user_name", nullable = false, length = 15)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String user_name;

    @Column(name = "publication_date")
    @JdbcTypeCode(SqlTypes.TIMESTAMP)
    private Timestamp publicationDate;



    @Column(name = "text",nullable = false)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String text;

}

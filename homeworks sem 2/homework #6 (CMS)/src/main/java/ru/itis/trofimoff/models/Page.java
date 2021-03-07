package ru.itis.trofimoff.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

// JPA
@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String route;
    @Length(max = 1000000)
    String content;
    Long parent_id;

//    @ManyToOne
//    @JoinColumn(name = "parent_id")
//    Page parent;
}

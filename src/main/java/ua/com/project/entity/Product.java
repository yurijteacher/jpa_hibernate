package ua.com.project.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String image;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categories;

}

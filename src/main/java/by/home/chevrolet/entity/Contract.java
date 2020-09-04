package by.home.chevrolet.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate contractDate;
    private LocalDate paymentDate;
    private LocalDate shipmentDate;
    @OneToMany
    private List<Car> carList;
    @ManyToOne
    private Client client;


}

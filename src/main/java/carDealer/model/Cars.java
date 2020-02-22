package carDealer.model;

import lombok.*;
import javax.persistence.*;


@Entity
@Table(name = "Cars")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Cars implements HibernateEntity {

    @ManyToOne
    @JoinColumn(name = "DealerId")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NonNull
    private Dealers dealers;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Brand")
    @OrderColumn
    @NonNull
    private String brand;

    @Column(name = "Model")
    @NonNull
    private String model;

    @Column(name = "Engine")
    @NonNull
    private String engine;

    @Column(name = "Year")
    @NonNull
    private String year;

    @Column(name = "Mileage")
    @NonNull
    private String mileage;

    @Column(name = "Colour")
    @NonNull
    private String colour;

    @Column(name = "Price")
    @NonNull
    private String price;


    public Cars() {
    }

}

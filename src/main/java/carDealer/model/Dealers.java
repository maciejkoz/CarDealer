package carDealer.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "Dealers")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Dealers implements HibernateEntity {

    @OneToMany(mappedBy = "dealers", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Cars> cars;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Column(name = "ID")
    private int id;

    @Column(name = "Name")
    @NonNull
    private String name;

    @Column(name = "Address")
    @NonNull
    private String address;

    @Column(name = "City")
    @NonNull
    private String city;

    @Column(name = "Phone")
    @NonNull
    @EqualsAndHashCode.Exclude
    private String phone;

@Column(name = "Email")
@Getter
@Setter
private String email;

    @Column(name = "OpenHours")
    @NonNull
    @EqualsAndHashCode.Exclude
    private String openHours;

    public Dealers(String name, String address, String city, String phone, String email, String openHours) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.openHours = openHours;
            }

    public Dealers(int id, String name, String address, String city, String phone, String email, String openHours) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.email = email;
        this.openHours = openHours;
    }

    public Dealers() {
    }
}

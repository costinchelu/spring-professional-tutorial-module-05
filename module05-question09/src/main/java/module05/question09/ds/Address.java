package module05.question09.ds;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Integer id;

    @NotBlank(message = "First name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "First name contains illegal characters")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Pattern(regexp = "[A-Za-z-']*", message = "Last name contains illegal characters")
    private String lastName;

    @NotBlank(message = "Street address cannot be empty")
    @Pattern(regexp = "[\\w .\\-/]*", message = "Street address contains illegal characters")
    private String streetAddress;

    @NotBlank(message = "City name cannot be empty")
    @Pattern(regexp = "[A-Za-z \\-]*", message = "City name contains illegal characters")
    private String city;

    @Pattern(regexp = "[A-Z]{2}", message = "State code needs to be 2 letter code")
    private String stateCode;

    @Pattern(regexp = "\\d{5}", message = "ZIP code needs to be 5 digit US ZIP code")
    private String zipCode;

    @NotBlank(message = "Country name cannot be empty")
    @Pattern(regexp = "[A-Za-z ]*", message = "Country name contains illegal characters")
    private String country;

    public Address(Person person, ShortAddress shortAddress, Country country) {
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.streetAddress = shortAddress.getStreetAddress();
        this.city = shortAddress.getCity();
        this.stateCode = shortAddress.getStateCode();
        this.zipCode = shortAddress.getZipCode();
        this.country = country.getCountry();
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Address address = (Address) o;
        return getId() != null && Objects.equals(getId(), address.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}

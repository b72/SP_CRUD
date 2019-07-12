package almamunb72.spring.com.demo.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {


    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private String registrationNo;
    private String address;


    public Publisher() {

    }

    public Publisher(String name, String registrationNo, String address) {
        this.name = name;
        this.registrationNo = registrationNo;
        this.address = address;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(Id, publisher.Id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", registrationNo='" + registrationNo + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

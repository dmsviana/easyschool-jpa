package domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("student")
public class Student extends User {

    /* 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; */

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Fee> fees;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", email='" + super.getEmail() + '\'' +
                '}';
    }

}

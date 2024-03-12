package domain;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "description")
    private String description;

    @ElementCollection(targetClass = DayOfWeek.class)
    @CollectionTable(name = "course_day_week", joinColumns = @JoinColumn(name = "course_id"))
    @Enumerated(EnumType.STRING)
    private List<DayOfWeek> daysOfWeek;

    @Column(nullable = false, name = "max_capacity")
    private int maxCapacity;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Student> students;
    

    @PrePersist
    public void prePersist(){
        if(students == null){
            students = List.of();
        }
    }

    public void addStudent(Student student){
        if (students.size() < maxCapacity){
            students.add(student);
        } else {
            throw new RuntimeException("Course is full");
        }
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}

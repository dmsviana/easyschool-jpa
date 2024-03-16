package domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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


    @OneToMany(fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "courses")
    private List<Teacher> teachers = new ArrayList<>();

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void removeTeacher(Teacher teacher) {
        teachers.remove(teacher);
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
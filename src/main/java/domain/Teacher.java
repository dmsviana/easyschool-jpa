package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_teachers")
@Getter
@Setter
@DiscriminatorValue("teacher")
public class Teacher extends User {

    @Column(name = "salary", nullable = false)
    private BigDecimal salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "teacher_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    

    public String toString() {
        return "Teacher: " + this.getName() +
                " - " + this.getEmail()
                + " - " + this.getPhoneNumber()
                + " - " + this.getRegistration();
    }
}
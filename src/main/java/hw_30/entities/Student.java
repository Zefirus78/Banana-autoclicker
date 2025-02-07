package hw_30.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "Students")
public class Student {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Getter
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Setter
    @Getter
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Setter
    @Getter
    @Column(name = "email", nullable = false)
    private String email;
    @Getter
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Homework> homeworks = new ArrayList<>();


    public Student(){}

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addHomework(final Homework h) {
        homeworks.add(h);
        h.setStudent(this);
    }

    public void removeHomework(final Homework h) {
        homeworks.remove(h);
        h.setStudent(null);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(email, student.email) && Objects.equals(homeworks, student.homeworks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, homeworks);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", homeworks=" + homeworks +
                '}';
    }
}

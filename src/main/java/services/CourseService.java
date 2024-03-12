package services;

import java.util.List;

import domain.Course;
import domain.Student;
import persistence.CourseRepository;
import persistence.StudentRepository;

public class CourseService {

    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;

    public CourseService(){
        this.courseRepository = new CourseRepository();
        this.studentRepository = new StudentRepository();
    }

    public void createCourse(Course course){
        if (course.getId() != null) {
            throw new IllegalArgumentException("Course ID must be null for new courses");
        }

        courseRepository.save(course);
    }

    public Course getCourseById(Long id){
        return courseRepository.getCourseById(id);
    }

    public List<Course> getAllCourses(){
        return courseRepository.getAllCourses();
    }

    public void updateCourse(Course course){
        courseRepository.updateCourse(course);
    }

    public void deleteCourse(Long id){
        courseRepository.deleteCourse(id);
    }

    public void addStudentToCourse(Long courseId, Long studentId){
        Course course = courseRepository.getCourseById(courseId);
        Student student = studentRepository.getStudentById(studentId);

        if(course == null || student == null){
            throw new IllegalArgumentException("Course or student not found");
        }

        course.addStudent(student);
        courseRepository.save(course);
    }

    public void removeStudentFromCourse(Long courseId, Long studentId){
        Course course = courseRepository.getCourseById(courseId);
        Student student = studentRepository.getStudentById(studentId);

        if(course == null || student == null){
            throw new IllegalArgumentException("Course or student not found");
        }

        course.removeStudent(student);
        courseRepository.save(course);
    }
    
}

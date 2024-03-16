package services;

import java.util.List;

import domain.Course;
import domain.Teacher;
import persistence.CourseRepository;
import persistence.TeacherRepository;

public class TeacherService {
    
    private final TeacherRepository teacherRepository;
        private final CourseRepository courseRepository; 

    public TeacherService() {
        this.teacherRepository = new TeacherRepository();
        this.courseRepository = new CourseRepository(); 
    }

    public void createTeacher(Teacher teacher) {
        if (teacher.getId() != null) {
            throw new IllegalArgumentException("Teacher ID must be null for new teachers");
        }

        try {
            teacherRepository.save(teacher);
        } catch (Exception ex) {
            throw new RuntimeException("Error creating teacher: " + ex.getMessage(), ex);
        }
    }

    public List<Teacher> findAllTeachers() {
        try {
            return teacherRepository.getAllTeachers();
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching teachers: " + ex.getMessage(), ex);
        }
    }

    public Teacher findTeacherById(Long id) {
        try {
            return teacherRepository.getTeacherById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error fetching teacher by ID: " + ex.getMessage(), ex);
        }
    }

    public void updateTeacher(Long id) {
        try {
            teacherRepository.updateTeacher(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error updating teacher: " + ex.getMessage(), ex);
        }
    }

    public void deleteTeacher(Long id) {
        try {
            teacherRepository.deleteTeacherById(id);
        } catch (Exception ex) {
            throw new RuntimeException("Error deleting teacher: " + ex.getMessage(), ex);
        }
    }

    public void addCourseToTeacher(Long teacherId, Long courseId) {
    Teacher teacher = teacherRepository.getTeacherById(teacherId);
    Course course = courseRepository.getCourseById(courseId);

    if(teacher == null || course == null){
        throw new IllegalArgumentException("Teacher or course not found");
    }

    teacher.addCourse(course); 
    course.addTeacher(teacher);
    teacherRepository.save(teacher);
    courseRepository.save(course);
}

public void removeCourseFromTeacher(Long teacherId, Long courseId) {
    Teacher teacher = teacherRepository.getTeacherById(teacherId);
    Course course = courseRepository.getCourseById(courseId);

    if(teacher == null || course == null){
        throw new IllegalArgumentException("Teacher or course not found");
    }

    
        teacher.removeCourse(course);
        course.removeTeacher(teacher);
        teacherRepository.save(teacher);
        courseRepository.save(course);
    
}
   
}

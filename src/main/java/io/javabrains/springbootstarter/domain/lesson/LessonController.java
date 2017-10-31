package io.javabrains.springbootstarter.domain.lesson;

import io.javabrains.springbootstarter.domain.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping(value = "/topics/{topicId}/courses/{id}/lessons", method = RequestMethod.GET)
    public List<Lesson> getAllLessons(@PathVariable String id) {
        return lessonService.getAllLessons(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{id}", method = RequestMethod.GET)
    public Lesson getLesson(@PathVariable String id) {
        return lessonService.getLesson(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{coursesId}/lessons", method = RequestMethod.POST)
    public void addLesson(@PathVariable String coursesId, @RequestBody Lesson lesson) {
        lesson.setCourse(new Course(coursesId, "", "", ""));
        lessonService.addLesson(lesson);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{id}", method = RequestMethod.PUT)
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String courseId, @PathVariable String id) {
        lesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.updateLesson(lesson);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{id}", method = RequestMethod.DELETE)
    public void deleteLesson(@PathVariable String id) {
        lessonService.deleteLesson(id);
    }

}

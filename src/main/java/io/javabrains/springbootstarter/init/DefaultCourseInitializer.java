package io.javabrains.springbootstarter.init;

import io.javabrains.springbootstarter.constants.Topics;
import io.javabrains.springbootstarter.domain.course.Course;
import io.javabrains.springbootstarter.domain.course.CourseService;
import io.javabrains.springbootstarter.domain.lesson.LessonService;
import io.javabrains.springbootstarter.domain.topic.Topic;
import io.javabrains.springbootstarter.domain.topic.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import static io.javabrains.springbootstarter.constants.Courses.*;
import static io.javabrains.springbootstarter.constants.Topics.*;

@Component
@AllArgsConstructor
public class DefaultCourseInitializer implements ApplicationRunner {

    private CourseService courseService;
    private TopicService topicService;
    private LessonService lessonService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Topic javaTopic = Topic.builder()
                .id(JAVA_ID)
                .name(JAVA_NAME)
                .description(JAVA_DESCRIPTION)
                .build();
        Topic scalaTopic = Topic.builder()
                .id(SCALA_ID)
                .name(SCALA_NAME)
                .description(SCALA_DESCRIPTION)
                .build();
        topicService.addTopic(javaTopic);
        topicService.addTopic(scalaTopic);

        courseService.addCourse(new Course(JAVA_STREAMS_ID, JAVA_STREAMS_NAME, JAVA_STREAMS_DESCRIPTION, Topics.JAVA_ID));

        courseService.addCourse(new Course(SCALA_FOR_IMPATIENT_ID, SCALA_FOR_IMPATIENT_NAME, SCALA_DESCRIPTION, Topics.SCALA_ID));

    }
}

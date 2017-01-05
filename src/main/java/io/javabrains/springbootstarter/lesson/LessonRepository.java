package io.javabrains.springbootstarter.lesson;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    public List<Lesson> findByName(String name);

    public List<Lesson> findByDescription(String description);

    public List<Lesson> findByCourseId(String topicId);
}

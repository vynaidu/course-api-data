package io.javabrains.springbootstarter.domain.lesson;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    public List<Lesson> findByName(String name);

    public List<Lesson> findByDescription(String description);

    List<Lesson> findByCourseId(String topicId);
}

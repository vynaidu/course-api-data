package io.javabrains.springbootstarter.domain.course;

import io.javabrains.springbootstarter.domain.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

	@Id
	private String id;
	private String name;
	private String description;
    @ManyToOne
    private Topic topic;

	public Course(String id, String name, String description, String topicId) {
		this.id = id;
		this.name = name;
		this.description = description;
        topic = new Topic(topicId, topicId, topicId);
    }
}

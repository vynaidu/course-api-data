package io.javabrains.springbootstarter.domain.topic;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

//    @Autowired
    private TopicRepository topicRepository;

    /*private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "Java script Description")));*/

    public List<Topic> getAllTopics() {
        ArrayList<Topic> topics = new ArrayList<>();
        topicRepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) {
        /*return topics.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .get();*/
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic) {
//        topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
        /*for (int index = 0; index < topics.size(); index++) {
            Topic currentTopic = topics.get(index);
            if (currentTopic.getId().equalsIgnoreCase(id)) {
                topics.set(index, topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.delete(id);
    }
}

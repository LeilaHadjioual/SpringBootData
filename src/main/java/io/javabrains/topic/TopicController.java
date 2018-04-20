package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController {

    @Autowired //déclare les dépendances
    private TopicService topicService; //créer une instance de topicservice

    //----------- METHODE GET --------------------------
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    //----------- METHODE POST --------------------------
    @RequestMapping(method = RequestMethod.POST, value = "/topics") //préciser la méthode post sinon get automatiquement
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    //----------- METHODE PUT --------------------------
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        topicService.updateTopic(id, topic);
    }

    //----------- METHODE DELETE --------------------------
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
    public void deleteTopic(@PathVariable String id) {
         topicService.deleteTopic(id);
    }
}

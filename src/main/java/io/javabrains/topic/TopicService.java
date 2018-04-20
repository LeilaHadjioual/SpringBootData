package io.javabrains.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

//    private List<Course> topics = new ArrayList<>(Arrays.asList( //AJOUT DE NEW ARRAY LORS DU POST POUR POUVOIR AJOUTER DES NOUVEAUX ELEMENTS
//            new Course("spring", "spring framework", "spring framework description"),
//            new Course("java", "core java", "core java description"),
//            new Course("javascript", "javascript", "javascript description")
//    ));

    //méthode qui récupère la liste topics déclarée plus haut
    public List<Topic> getAllTopics() { //GET ALL topics
        //return topics;
        List<Topic> topics = new ArrayList<>(); //créer une nouvelle liste de type topic
        topicRepository.findAll()               //recup tous les topics de la bdd
        .forEach(topics::add);
        return topics;
    }

    public Topic getTopic(String id) { //GET EN FONCTION DE L'ID
//        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); //compare l'id d'un topic, récupère le 1er topic et le retourne
        return topicRepository.findById(id).get();
    }

    public void addTopic(Topic topic) {  //POST
        //topics.add(topic);
        topicRepository.save(topic);
    }

    public void updateTopic(String id, Topic topic) {
//        for (int i =0 ; i < topics.size(); i++) {
//            Course t = topics.get(i);
//            if (t.getId().equals(id)) {
//                topics.set(i, topic);
//                return;
//            }
//        }
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
//        topics.removeIf(t ->t.getId().equals(id));
        topicRepository.deleteById(id);
    }
}

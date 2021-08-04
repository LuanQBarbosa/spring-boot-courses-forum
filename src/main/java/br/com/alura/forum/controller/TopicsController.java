package br.com.alura.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.Topic;

@RestController
public class TopicsController {

	@RequestMapping("/topics")
	public List<TopicDto> list() {
		Topic topic = new Topic("Question", "Question for Spring", new Course("Spring", "Programming"));
		
		return TopicDto.convert(Arrays.asList(topic, topic, topic));
	}
	
}

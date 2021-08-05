package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.dto.TopicDetailsDto;
import br.com.alura.forum.controller.dto.TopicDto;
import br.com.alura.forum.controller.form.TopicForm;
import br.com.alura.forum.controller.form.TopicUpdateForm;
import br.com.alura.forum.model.Topic;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.TopicRepository;

@RestController
@RequestMapping("/topics")
public class TopicsController {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping
	public List<TopicDto> list(String courseName) {
		if (courseName == null) {
			List<Topic> topics = topicRepository.findAll();			
			return TopicDto.convert(topics);
		} else {
			List<Topic> topics = topicRepository.findByCourseName(courseName);			
			return TopicDto.convert(topics);
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicDto> register(@RequestBody @Valid TopicForm form, UriComponentsBuilder uriBuilder) {
		Topic topic = form.convert(courseRepository);
		topicRepository.save(topic);
		
		URI uri = uriBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicDto(topic));
	}
	
	@GetMapping("/{id}")
	public TopicDetailsDto detail(@PathVariable Long id) {
		Topic topic = topicRepository.getById(id);
		return new TopicDetailsDto(topic);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<TopicDto> update(@PathVariable Long id, @RequestBody @Valid TopicUpdateForm form) {
		Topic topic = form.update(id, topicRepository);
		
		return ResponseEntity.ok(new TopicDto(topic));
	}
	
}

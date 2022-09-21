package com.devsuperior.myfirstproject.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.myfirstproject.entities.Category;
import com.devsuperior.myfirstproject.repositories.CategoryRepository;

@RestController //define que a classe vai ser um recurso REST
@RequestMapping(value = "/categories") //define o caminho pelo qual esse recurso vai responder
public class CategoryResource {

		@Autowired
		private CategoryRepository repository;
	
		@GetMapping
		public ResponseEntity<List<Category>> findAll() {
			List<Category> list = repository.findAll();
			return ResponseEntity.ok().body(list);
		}
		
		@GetMapping(value = "/{id}")
		public ResponseEntity<Category> findById(@PathVariable Long id) {
			Category cat = repository.findById(id);
			return ResponseEntity.ok().body(cat);
		}
}

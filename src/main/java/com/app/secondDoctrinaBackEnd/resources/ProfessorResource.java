package com.app.secondDoctrinaBackEnd.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.secondDoctrinaBackEnd.domain.Professor;

@RestController
@RequestMapping(value = "/profs")
public class ProfessorResource {
	//lista todos os professores
		@RequestMapping(method=RequestMethod.GET)
		public List<Professor> listar() {
			Professor p1 = new Professor(1, "Danielli", "dani@gmail.com", "iftm", "foto dani");
			Professor p2 = new Professor(2, "Tamara", "tamara@gmail.com", "eeja", "foto tamara");

			List<Professor> listaprof = new ArrayList<>();
			listaprof.add(p1);
			listaprof.add(p2);

			return listaprof;
		}
/*
	@Autowired
	private ProfessorService service; // acessa o servico
*/
	// lista os professores por id
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Professor> find(@PathVariable Integer id) {
		Professor obj = service.find(id);
		return ResponseEntity.ok(obj);
	}*/

	// INSERIR
	/*
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Professor obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build(); // cria o codigo 201, que é o codigo de cadastro
	}*

	// ATUALIZAR
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Professor obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	*/

	// DELETAR
	/*
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}*/

	// listar todos os professores
	/*
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProfessorDTO>> findAll() {
		List<Professor> list = service.findAll();
		List<ProfessorDTO> listDto = list.stream().map(obj -> new ProfessorDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok(listDto);
	}*/
	


	// paginacao
	/*
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ProfessorDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Professor> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ProfessorDTO> listDto = list.map(obj -> new ProfessorDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	*/
}
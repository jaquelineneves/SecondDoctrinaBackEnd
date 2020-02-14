package com.app.secondDoctrinaBackEnd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String foto;

    // disciplina tem 1 professor
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    // disciplina tem varios modulos, foi mapeado pelo campo disciplina
    @OneToMany(mappedBy = "disciplina")
    private List<Modulo> modulos = new ArrayList<>();
    
	// o cascade é necessário pq senao da erro (e pq se excluir uma disciplina tem que excluir os modulos)
/*
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "disciplina")
    private List<Modulo> modulos = new ArrayList<>();
*/

	@JsonIgnore
    @OneToMany(mappedBy="id.disciplina")
    private Set<NotaDisciplina> notasDisc = new HashSet<>();
    
    public Disciplina(){

    }

    // td que for colecao, mais de um, vc nao coloca
    public Disciplina(Integer id, String nome, String foto, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.foto = foto;
        this.professor = professor;
    }
    
    //uma disciplina conhece os alunos dela
	@JsonIgnore
    public List<Aluno> getAlunos() {
    	List<Aluno> lista = new ArrayList<>();
    	for (NotaDisciplina x : notasDisc) {
    		lista.add(x.getAluno());
    	}
    	return lista;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(List<Modulo> modulos) {
        this.modulos = modulos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }    
    
    public Set<NotaDisciplina> getNotasDisc() {
		return notasDisc;
	}

	public void setNotasDisc(Set<NotaDisciplina> notasDisc) {
		this.notasDisc = notasDisc;
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
package com.app.secondDoctrinaBackEnd.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class NotaDisciplina implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private NotaDisciplinaPK id = new NotaDisciplinaPK();
	
	private double notaDisciplina;
	
	public NotaDisciplina() {
		
	}

	public NotaDisciplina(Aluno aluno, Disciplina disciplina, double notaDisciplina) {
		super();
		id.setAluno(aluno);
		id.setDisciplina(disciplina);
		this.notaDisciplina = notaDisciplina;
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return id.getAluno();
	}
	
	public Disciplina getDisciplina() {
		return id.getDisciplina();
	}

	public NotaDisciplinaPK getId() {
		return id;
	}

	public void setId(NotaDisciplinaPK id) {
		this.id = id;
	}

	public double getNotaDisciplina() {
		return notaDisciplina;
	}

	public void setNotaDisciplina(double notaDisciplina) {
		this.notaDisciplina = notaDisciplina;
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
		NotaDisciplina other = (NotaDisciplina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
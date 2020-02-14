package com.app.secondDoctrinaBackEnd.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.app.secondDoctrinaBackEnd.enums.FormaAprendizagem;


@Entity
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String instituicao;
    private Integer formaAprendizagem; //aqui no codigo vai ser armazenado como um inteiro, porem para o mundo externo a classe vai expor um dado NivelDificuldade
    private Integer xp;
    private String foto;
    
    @OneToMany(mappedBy="id.aluno")
    private Set<NotaDisciplina> notasDisc = new HashSet<>();
    
    public Aluno (){

    }

    public Aluno(Integer id, String nome, String email, String instituicao, FormaAprendizagem formaAprendizagem, Integer xp, String foto) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.instituicao = instituicao;
		this.formaAprendizagem = formaAprendizagem.getCod();
		this.xp = xp;
		this.foto = foto;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public FormaAprendizagem getFormaAprendizagem() {
        return FormaAprendizagem.ToEnum(formaAprendizagem);
    }

    public void setFormaAprendizagem(FormaAprendizagem formaAprendizagem) {
        this.formaAprendizagem = formaAprendizagem.getCod();
    }

	public Integer getXp() {
		return xp;
	}

	public void setXp(Integer xp) {
		this.xp = xp;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
		Aluno other = (Aluno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
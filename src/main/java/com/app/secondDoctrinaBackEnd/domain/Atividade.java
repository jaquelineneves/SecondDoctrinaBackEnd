package com.app.secondDoctrinaBackEnd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Atividade implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private Integer qtdTentativas;
    private Integer contadorTentativas;
    private double notaInicial;
    private double notaFinal;
    private String foto;
    
    // atividade tem 1 modulo
    @ManyToOne
    @JoinColumn(name="modulo_id")
    private Modulo modulo;
    
    // pq uma atividade vai ter varias perguntas
    // atividade tem varios perguntas, foi mapeado pelo campo atividade
    @OneToMany(mappedBy = "atividade")
    private List<Pergunta> perguntas = new ArrayList<>();
    
    /*
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "atividade")
    private List<Pergunta> perguntas = new ArrayList<>();
    */    
    
    public Atividade() {
    	
    }
    
    public Atividade(Integer id, Integer qtdTentativas, Integer contadorTentativas, double notaInicial, double notaFinal, String foto, Modulo modulo) {
		super();
		this.id = id;
		this.qtdTentativas = qtdTentativas;
		this.contadorTentativas = contadorTentativas;
		this.notaInicial = notaInicial;
		this.notaFinal = notaFinal;
		this.foto = foto;
        this.modulo = modulo;
	}
    
	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQtdTentativas() {
		return qtdTentativas;
	}

	public void setQtdTentativas(Integer qtdTentativas) {
		this.qtdTentativas = qtdTentativas;
	}

	public Integer getContadorTentativas() {
		return contadorTentativas;
	}

	public void setContadorTentativas(Integer contadorTentativas) {
		this.contadorTentativas = contadorTentativas;
	}

	public double getNotaInicial() {
		return notaInicial;
	}

	public void setNotaInicial(double notaInicial) {
		this.notaInicial = notaInicial;
	}

	public double getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(double notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
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
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

package com.app.secondDoctrinaBackEnd.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.app.secondDoctrinaBackEnd.enums.NivelDificuldade;
import com.app.secondDoctrinaBackEnd.enums.Tag;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Modulo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private String linkVideo;
    private String pdfMateria;
    private Integer tag;
    private double notaModulo;
    private Integer nivelDificuldade; //aqui no codigo vai ser armazenado como um inteiro, porem para o mundo externo a classe vai expor um dado NivelDificuldade
    private Integer feromonio;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date dataReforco;
    
    @JsonFormat(pattern="dd/MM/yyyy")
    private Date tempoSemReforco;
    
    /*SQL TESTE*/
    /*
     * INSERT INTO MODULO (DATA_REFORCO, DESCRICAO, FEROMONIO, LINK_VIDEO, NIVEL_DIFICULDADE, NOME, NOTA_MODULO, PDF_MATERIA, TAG, TEMPO_SEM_REFORCO, DISCIPLINA_ID)
	   VALUES ('2018-10-20','descricao do modulo',2,'link video',1,'estatistica',5.0,'pdf mat',2,'2018-10-10',1);
     */
    
    // modulo tem varias atividades, foi mapeado pelo campo modulo
 	@JsonIgnore
    @OneToMany(mappedBy = "modulo")
 	private List<Atividade> atividades = new ArrayList<>();
 	

    // modulo tem 1 disciplina
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="disciplina_id")
    private Disciplina disciplina;

    public Modulo (){

    }

    public Modulo(Integer id, String nome, String descricao, String linkVideo, String pdfMateria, Tag tag, double notaModulo, NivelDificuldade nivelDificuldade, Integer feromonio, Date dataReforco, Date tempoSemReforco, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.linkVideo = linkVideo;
        this.pdfMateria = pdfMateria;
        this.tag = tag.getCod();
        this.notaModulo = notaModulo;
        this.nivelDificuldade = nivelDificuldade.getCod();
        this.feromonio = feromonio;
        this.dataReforco = dataReforco;
        this.tempoSemReforco = tempoSemReforco;
        this.disciplina = disciplina;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public String getPdfMateria() {
        return pdfMateria;
    }

    public void setPdfMateria(String pdfMateria) {
        this.pdfMateria = pdfMateria;
    }

    public Tag getTag() {
        return Tag.ToEnum(tag);
    }

    public void setTag(Tag tag) {
        this.tag = tag.getCod();
    }

    public double getNotaModulo() {
        return notaModulo;
    }

    public void setNotaModulo(double notaModulo) {
        this.notaModulo = notaModulo;
    }

    public NivelDificuldade getNivelDificuldade() {
        return NivelDificuldade.ToEnum(nivelDificuldade);
    }

    public void setNivelDificuldade(NivelDificuldade nivelDificuldade) {
        this.nivelDificuldade = nivelDificuldade.getCod();
    }

    public Integer getFeromonio() {
        return feromonio;
    }

    public void setFeromonio(Integer feromonio) {
        this.feromonio = feromonio;
    }

    public Date getDataReforco() {
        return dataReforco;
    }

    public void setDataReforco(Date dataReforco) {
        this.dataReforco = dataReforco;
    }

    public Date getTempoSemReforco() {
        return tempoSemReforco;
    }

    public void setTempoSemReforco(Date tempoSemReforco) {
        this.tempoSemReforco = tempoSemReforco;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
		Modulo other = (Modulo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
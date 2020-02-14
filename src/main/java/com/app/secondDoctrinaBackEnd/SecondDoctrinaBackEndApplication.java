package com.app.secondDoctrinaBackEnd;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.secondDoctrinaBackEnd.domain.Administrador;
import com.app.secondDoctrinaBackEnd.domain.Aluno;
import com.app.secondDoctrinaBackEnd.domain.Atividade;
import com.app.secondDoctrinaBackEnd.domain.Disciplina;
import com.app.secondDoctrinaBackEnd.domain.Modulo;
import com.app.secondDoctrinaBackEnd.domain.NotaDisciplina;
import com.app.secondDoctrinaBackEnd.domain.Pergunta;
import com.app.secondDoctrinaBackEnd.domain.Professor;
import com.app.secondDoctrinaBackEnd.enums.FormaAprendizagem;
import com.app.secondDoctrinaBackEnd.enums.NivelDificuldade;
import com.app.secondDoctrinaBackEnd.enums.Tag;
import com.app.secondDoctrinaBackEnd.repositories.AdministradorRepository;
import com.app.secondDoctrinaBackEnd.repositories.AlunoRepository;
import com.app.secondDoctrinaBackEnd.repositories.AtividadeRepository;
import com.app.secondDoctrinaBackEnd.repositories.DisciplinaRepository;
import com.app.secondDoctrinaBackEnd.repositories.ModuloRepository;
import com.app.secondDoctrinaBackEnd.repositories.NotaDisciplinaRepository;
import com.app.secondDoctrinaBackEnd.repositories.PerguntaRepository;
import com.app.secondDoctrinaBackEnd.repositories.ProfessorRepository;


@SpringBootApplication
public class SecondDoctrinaBackEndApplication implements CommandLineRunner{
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private AdministradorRepository administradorRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private ModuloRepository moduloRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private PerguntaRepository perguntaRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private NotaDisciplinaRepository notaDisciplinaRepository;
	
		
	public static void main(String[] args) {
		SpringApplication.run(SecondDoctrinaBackEndApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Administrador adm = new Administrador(1, "admin", "admin@gmail.com", "foto aqui");
		
		Professor prof1 = new Professor(null,"Danielli","dani@gmail.com", "iftm","ft dani");
		Professor prof2 = new Professor(null,"tâmara","tamara@gmail.com", "people","ft tâmara");
		Professor prof3 = new Professor(null,"Ana luiza","ana@gmail.com", "iftm","ft ana");
		Professor prof4 = new Professor(null,"Bruna","bruna@gmail.com", "people","ft bruna");
		Professor prof5 = new Professor(null,"Camila","camila@gmail.com", "iftm","ft camila");
		Professor prof6 = new Professor(null,"Eriele","eriele@gmail.com", "upr","ft eriele");
		
		Disciplina disc1 = new Disciplina(null, "TCC", "foto da disciplina", prof1);
		Disciplina disc2 = new Disciplina(null, "IA", "foto de IA", prof1);
		Disciplina disc3 = new Disciplina(null, "BD", "foto de BD", prof2);
	
		//fazer instancia de modulo, mas nao sei fazer pq tem enum, olhar como ele fez a de cliente
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Modulo mod1 = new Modulo(null, "Módulo 1 de TCC", "descricao do modulo 1", "link video modulo 1", "link pdf do modulo 1", Tag.FEITO, 5.0, NivelDificuldade.FACIL, 2, sdf.parse("30/09/2017 10:32"), sdf.parse("30/02/2020 10:32"), disc1);
		Modulo mod2 = new Modulo(null, "Módulo 1 de IA", "descricao do modulo 1", "link video modulo 1", "link pdf do modulo 1", Tag.FEITO, 5.0, NivelDificuldade.FACIL, 2, sdf.parse("30/09/2017 10:32"), sdf.parse("30/02/2020 10:32"), disc2);
		Modulo mod3 = new Modulo(null, "Módulo 2 de IA", "descricao do modulo 2", "link video modulo 2", "link pdf do modulo 2", Tag.NAO_FEITO, 9.0, NivelDificuldade.MEDIO, 2, sdf.parse("30/09/2017 10:32"), sdf.parse("30/02/2020 10:32"), disc2);
	
		Atividade atividade1 = new Atividade(null, 3, 2, 0.0, 10, "foto atividade 1", mod1);
		Atividade atividade2 = new Atividade(null, 8, 10, 0.0, 2, "foto atividade 2", mod1);
		Atividade atividade3 = new Atividade(null, 4, 6, 0.0, 1, "foto atividade 3", mod2);
		Atividade atividade4 = new Atividade(null, 6, 5, 0.0, 5, "foto atividade 4", mod3);

		Pergunta pergunta1 = new Pergunta(null,"pergunta um","teste um","teste dois","teste tres","letra C", 10.5, atividade1);
		Pergunta pergunta2 = new Pergunta(null,"pergunta dois","teste um","teste dois","teste tres","letra A", 2, atividade2);
		Pergunta pergunta3 = new Pergunta(null,"pergunta tres","teste a","teste b","teste c","letra B", 4, atividade2);
		
		Aluno aluno1 = new Aluno(null, "Jaqueline Neves", "jaque@gmail.com", "iftm", FormaAprendizagem.VIDEO, 2, "foto de perfil jaque");
		Aluno aluno2 = new Aluno(null, "Juliana Cristina", "juliana@gmail.com", "ufu", FormaAprendizagem.LEITURA, 3, "foto de perfil Juliana");

		professorRepository.saveAll(Arrays.asList(prof1, prof2, prof3, prof4, prof5, prof6));
		administradorRepository.saveAll(Arrays.asList(adm));
		disciplinaRepository.saveAll(Arrays.asList(disc1, disc2, disc3));
		moduloRepository.saveAll(Arrays.asList(mod1, mod2, mod3));
		
		atividadeRepository.saveAll(Arrays.asList(atividade1, atividade2, atividade3, atividade4));
		perguntaRepository.saveAll(Arrays.asList(pergunta1, pergunta2, pergunta3));
				
		NotaDisciplina notaDisc1 = new NotaDisciplina(aluno1, disc1, 8.5);
		NotaDisciplina notaDisc2 = new NotaDisciplina(aluno1, disc2, 9.0);
		NotaDisciplina notaDisc3 = new NotaDisciplina(aluno2, disc2, 8.6);
		
		//Aluno tem essas notas aqui o 
		aluno1.getNotasDisc().addAll(Arrays.asList(notaDisc1, notaDisc2));
		aluno2.getNotasDisc().addAll(Arrays.asList(notaDisc3));
		
		
		//Disciplina conhecer as suas notas
		disc1.getNotasDisc().addAll(Arrays.asList(notaDisc1));
		disc2.getNotasDisc().addAll(Arrays.asList(notaDisc2, notaDisc3));	
		
		alunoRepository.saveAll(Arrays.asList(aluno1, aluno2));
		notaDisciplinaRepository.saveAll(Arrays.asList(notaDisc1, notaDisc2, notaDisc3));	
		
	}
}

package br.edu.infnet.appMatheusAvelino.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Classe que representa um psicólogo no sistema.
 * Esta classe é uma entidade JPA, mapeada para a tabela {@code TPSicologo} no banco de dados.
 * A classe {@code Psicologo} estende {@code Usuario}, herdando seus atributos e comportamentos.
 * 
 * <p>O psicólogo possui um campo {@code crp} que é único, um relacionamento muitos-para-um com {@code Abordagem},
 * e um relacionamento um-para-muitos com {@code Atendimento}. O relacionamento com {@code Atendimento} é carregado
 * de forma imediata (EAGER) e as operações de remoção são propagadas com {@code CascadeType.REMOVE}. O atributo 
 * {@code orphanRemoval=true} assegura que atendimentos sem um psicólogo associado sejam removidos automaticamente.</p>
 * 
 * <p>A classe inclui métodos para adicionar atendimentos e acessar os atributos da entidade.</p>
 * 
 * @see Usuario
 * @see Abordagem
 * @see Atendimento
 */
@Entity
@Table(name = "TPsicologo")
public class Psicologo extends Usuario {

    /**
     * Número do Conselho Regional de Psicologia, deve ser único.
     */
    @Column(unique = true)
    private String crp;

    /**
     * Relacionamento muitos-para-um com a entidade {@code Abordagem}.
     * Um psicólogo pode ter uma abordagem específica, mas uma abordagem pode ser compartilhada entre vários psicólogos.
     */
    @ManyToOne
    @JoinColumn(name = "idAbordagem")
    private Abordagem abordagem;

    /**
     * Relacionamento um-para-muitos com a entidade {@code Atendimento}.
     * Um psicólogo pode ter muitos atendimentos, e esses atendimentos são carregados de forma imediata (EAGER).
     * {@code CascadeType.REMOVE} indica que ao remover um psicólogo, todos os seus atendimentos associados serão removidos.
     * {@code orphanRemoval=true} assegura que qualquer atendimento sem psicólogo associado seja removido automaticamente.
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPsicologo")
    @JsonManagedReference
    private List<Atendimento> atendimentos = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Psicologo() {
    }

    /**
     * Construtor que inicializa os atributos do psicólogo.
     * 
     * @param nomeCompleto Nome completo do psicólogo.
     * @param email Email do psicólogo.
     * @param idade Idade do psicólogo.
     * @param crp Número do CRP do psicólogo.
     * @param abordagem Abordagem associada ao psicólogo.
     */
    public Psicologo(String nomeCompleto, String email, int idade, String crp, Abordagem abordagem) {
        super(nomeCompleto, email, idade);
        this.crp = crp;
        this.abordagem = abordagem;
    }

    /**
     * Adiciona um atendimento à lista de atendimentos do psicólogo e também à lista de atendimentos do paciente.
     * 
     * @param atendimento Atendimento a ser adicionado.
     * @param paciente Paciente ao qual o atendimento será associado.
     */
    public void marcarAtendimento(Atendimento atendimento, Paciente paciente) {
        this.atendimentos.add(atendimento);
        paciente.getAtendimento().add(atendimento);
    }

    // Getters e Setters

    public String getCrp() {
        return crp;
    }

    public void setCrp(String crp) {
        this.crp = crp;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public Abordagem getAbordagem() {
        return abordagem;
    }

    public void setAbordagem(Abordagem abordagem) {
        this.abordagem = abordagem;
    }

    /**
     * Retorna uma representação textual do psicólogo.
     * 
     * @return Uma string representando o psicólogo, incluindo informações herdadas da classe {@code Usuario}, o CRP, a abordagem e a lista de atendimentos.
     */
    @Override
    public String toString() {
        return "Psicologo{" + super.toString() + ", CRP: " + crp + ", [" + abordagem + "], [ " + atendimentos + "] }";
    }
}

package br.edu.infnet.appMatheusAvelino.model.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Representa um paciente no sistema.
 * <p>
 * Esta classe estende a classe {@link Usuario} e é mapeada para a tabela "TPaciente" no banco de dados.
 * </p>
 * <p>
 * Um paciente possui um número de CPF único e pode ter múltiplos atendimentos.
 * </p>
 */
@Entity
@Table(name = "TPaciente")
public class Paciente extends Usuario {

    /**
     * Número de Cadastro de Pessoa Física (CPF) do paciente.
     * Deve ser único para cada paciente.
     */
    @Column(unique = true)
    private String cpf;

    /**
     * Relacionamento um-para-muitos com a entidade {@link Atendimento}.
     * Um paciente pode ter muitos atendimentos.
     * <p>
     * Os atendimentos são carregados de forma EAGER (imediata) e, ao remover um paciente, todos os atendimentos associados são removidos.
     * Se um atendimento ficar órfão (sem paciente associado), será removido automaticamente.
     * </p>
     */
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "idPaciente")
    @JsonManagedReference
    private List<Atendimento> atendimento = new ArrayList<>();

    /**
     * Construtor padrão.
     */
    public Paciente() {
    }

    /**
     * Construtor com parâmetros.
     * 
     * @param nomeCompleto o nome completo do paciente
     * @param email o endereço de e-mail do paciente
     * @param idade a idade do paciente
     * @param cpf o número de CPF do paciente
     */
    public Paciente(String nomeCompleto, String email, int idade, String cpf) {
        super(nomeCompleto, email, idade);
        this.cpf = cpf;
    }

    /**
     * Obtém o número de CPF do paciente.
     * 
     * @return o CPF do paciente
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o número de CPF do paciente.
     * 
     * @param cpf o CPF do paciente
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Obtém a lista de atendimentos do paciente.
     * 
     * @return a lista de atendimentos
     */
    public List<Atendimento> getAtendimento() {
        return atendimento;
    }

    /**
     * Define a lista de atendimentos do paciente.
     * 
     * @param atendimento a lista de atendimentos
     */
    public void setAtendimento(List<Atendimento> atendimento) {
        this.atendimento = atendimento;
    }

    /**
     * Representa uma string contendo as informações do paciente.
     * 
     * @return uma string com os detalhes do paciente, incluindo CPF e atendimentos
     */
    @Override
    public String toString() {
        return "Paciente{ " + super.toString() + ", CPF: " + cpf + ", [" + atendimento + "] }";
    }
}

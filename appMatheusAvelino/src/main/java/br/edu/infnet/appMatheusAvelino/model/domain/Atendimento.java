package br.edu.infnet.appMatheusAvelino.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Representa um atendimento no sistema.
 * <p>
 * Esta classe é mapeada para a tabela "TAtendimento" no banco de dados.
 * </p>
 */
@Entity
@Table(name = "TAtendimento")
public class Atendimento {

    /**
     * Identificador único do atendimento.
     * <p>
     * A geração do valor do ID será feita automaticamente pelo banco de dados.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Psicólogo responsável pelo atendimento.
     * <p>
     * O psicólogo não pode ser nulo, indicando que cada atendimento deve ter um psicólogo associado.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "idPsicologo")
    @NotNull(message = "O psicólogo não pode ser nulo.")
    @JsonBackReference
    private Psicologo psicologo;

    /**
     * Paciente que recebe o atendimento.
     * <p>
     * O paciente não pode ser nulo, indicando que cada atendimento deve ter um paciente associado.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "idPaciente")
    @NotNull(message = "O paciente não pode ser nulo.")
    @JsonBackReference
    private Paciente paciente;

    /**
     * Tipo de atendimento realizado.
     * <p>
     * Este campo não pode ser vazio e deve ter no máximo 100 caracteres.
     * </p>
     */
    @NotBlank(message = "O tipo de atendimento não pode ser vazio.")
    @Size(max = 100, message = "O tipo de atendimento deve ter no máximo 100 caracteres.")
    private String tipoAtendimento;

    /**
     * Data em que o atendimento foi realizado.
     * <p>
     * Este campo não pode ser vazio.
     * </p>
     */
    @NotBlank(message = "A data de atendimento não pode ser vazia.")
    private String atendimentoDate;

    /**
     * Status do atendimento.
     * <p>
     * Verdadeiro para efetivado e falso para em andamento.
     * </p>
     */
    private boolean statusAtendimento;

    /**
     * Construtor padrão da classe.
     */
    public Atendimento() {

    }

    /**
     * Construtor da classe com data e tipo de atendimento.
     * 
     * @param data a data do atendimento
     * @param tipoAtendimento o tipo de atendimento
     */
    public Atendimento(String data, String tipoAtendimento) {
        this.atendimentoDate = data;
        this.tipoAtendimento = tipoAtendimento;
        this.statusAtendimento = false;
    }

    /**
     * Obtém o identificador único do atendimento.
     * 
     * @return o ID do atendimento
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador único do atendimento.
     * 
     * @param id o ID do atendimento
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o tipo de atendimento realizado.
     * 
     * @return o tipo de atendimento
     */
    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    /**
     * Define o tipo de atendimento realizado.
     * 
     * @param tipoAtendimento o tipo de atendimento
     */
    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    /**
     * Obtém a data em que o atendimento foi realizado.
     * 
     * @return a data do atendimento
     */
    public String getAtendimentoDate() {
        return atendimentoDate;
    }

    /**
     * Define a data em que o atendimento foi realizado.
     * 
     * @param atendimentoDate a data do atendimento
     */
    public void setAtendimentoDate(String atendimentoDate) {
        this.atendimentoDate = atendimentoDate;
    }

    /**
     * Obtém o status do atendimento.
     * 
     * @return o status do atendimento
     */
    public boolean isStatusAtendimento() {
        return statusAtendimento;
    }

    /**
     * Define o status do atendimento.
     * 
     * @param statusAtendimento o status do atendimento
     */
    public void setStatusAtendimento(boolean statusAtendimento) {
        this.statusAtendimento = statusAtendimento;
    }

    /**
     * Obtém o psicólogo responsável pelo atendimento.
     * 
     * @return o psicólogo do atendimento
     */
    public Psicologo getPsicologo() {
        return psicologo;
    }

    /**
     * Define o psicólogo responsável pelo atendimento.
     * 
     * @param psicologo o psicólogo do atendimento
     */
    public void setPsicologo(Psicologo psicologo) {
        this.psicologo = psicologo;
    }

    /**
     * Obtém o paciente que recebe o atendimento.
     * 
     * @return o paciente do atendimento
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Define o paciente que recebe o atendimento.
     * 
     * @param paciente o paciente do atendimento
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Representa uma string contendo as informações do atendimento.
     * 
     * @return uma string com os detalhes do atendimento
     */
    @Override
    public String toString() {
        return "Atendimento{" + id + ", [PsicologoId: " + psicologo.getId() + "], [PacienteId: " + paciente.getId()
                + "], Data: " + atendimentoDate + ", Tipo de Atendimento: " + tipoAtendimento + ", Status Atendimento: "
                + (statusAtendimento ? "Efetuado" : "Em andamento") + "}";
    }
}

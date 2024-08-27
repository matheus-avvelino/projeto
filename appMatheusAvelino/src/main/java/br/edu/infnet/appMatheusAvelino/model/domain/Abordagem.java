package br.edu.infnet.appMatheusAvelino.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Representa uma abordagem no sistema.
 * <p>
 * Esta classe é mapeada para a tabela "TAbordagem" no banco de dados.
 * </p>
 */
@Entity
@Table(name = "TAbordagem")
public class Abordagem {

    /**
     * Identificador único da abordagem.
     * <p>
     * A geração do valor do ID será feita automaticamente pelo banco de dados.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Descrição da abordagem.
     * <p>
     * Este campo não pode ser vazio e deve ter no máximo 50 caracteres.
     * </p>
     */
    @Size(max = 50, message = "O tipo de DESCRICAO deve ter no máximo 50 caracteres.")
    @NotBlank(message = "Necessário o preenchimento do campo DESCRICAO")
    private String descricao;

    /**
     * Construtor padrão da classe.
     */
    public Abordagem() {
    }

    /**
     * Construtor da classe com descrição da abordagem.
     * 
     * @param descricao a descrição da abordagem
     */
    public Abordagem(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o identificador único da abordagem.
     * 
     * @return o ID da abordagem
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador único da abordagem.
     * 
     * @param id o ID da abordagem
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém a descrição da abordagem.
     * 
     * @return a descrição da abordagem
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da abordagem.
     * 
     * @param descricao a descrição da abordagem
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Representa uma string contendo as informações da abordagem.
     * 
     * @return uma string com os detalhes da abordagem
     */
    @Override
    public String toString() {
        return "Abordagem{" + "ID: " + id + ", Descrição: " + descricao + "}";
    }
}

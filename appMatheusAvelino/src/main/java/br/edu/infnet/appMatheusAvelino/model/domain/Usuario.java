package br.edu.infnet.appMatheusAvelino.model.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Classe abstrata representando um usuário do sistema.
 * <p>
 * Esta classe é mapeada para a tabela "TUsuario" no banco de dados e utiliza a estratégia de herança JOINED,
 * onde cada subclasse terá sua própria tabela e será feita uma junção entre a tabela da subclasse e a tabela base.
 * </p>
 * <p>
 * A classe define os campos básicos de um usuário, como nome completo, e-mail e idade, além de um relacionamento
 * um-para-um com a entidade {@link Endereco}.
 * </p>
 */
@Entity
@Table(name = "TUsuario")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    /**
     * Identificador único do usuário. 
     * Gerado automaticamente pelo banco de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Nome completo do usuário. 
     * Este campo é obrigatório e não pode ser nulo ou vazio.
     */
    @NotBlank(message = "Necessario o preechimento do campo NOMECOMPLETO")
    private String nomeCompleto;

    /**
     * Endereço de e-mail do usuário. 
     * Este campo é obrigatório e não pode ser nulo ou vazio.
     */
    @NotBlank(message = "Necessario o preechimento do campo email")
    private String email;

    /**
     * Idade do usuário. 
     * Deve ser, no mínimo, 18 anos.
     */
    @Min(value = 18, message = "Necessario que o valor de IDADE sejá maior ou igual a 18")
    private int idade;

    /**
     * Endereço associado ao usuário.
     * Este relacionamento é um-para-um e a persistência do usuário também persiste o endereço associado.
     */
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idEndereco")
    private Endereco endereco;

    /**
     * Construtor padrão.
     */
    public Usuario() {
    }

    /**
     * Construtor com parâmetros.
     * 
     * @param nomeCompleto o nome completo do usuário
     * @param email o endereço de e-mail do usuário
     * @param idade a idade do usuário
     */
    public Usuario(String nomeCompleto, String email, int idade) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.idade = idade;
    }

    /**
     * Obtém o identificador do usuário.
     * 
     * @return o identificador do usuário
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador do usuário.
     * 
     * @param id o identificador do usuário
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o endereço de e-mail do usuário.
     * 
     * @return o endereço de e-mail do usuário
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o endereço de e-mail do usuário.
     * 
     * @param email o endereço de e-mail do usuário
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o nome completo do usuário.
     * 
     * @return o nome completo do usuário
     */
    public String getNomeCompleto() {
        return nomeCompleto;
    }

    /**
     * Define o nome completo do usuário.
     * 
     * @param nomeCompleto o nome completo do usuário
     */
    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    /**
     * Obtém a idade do usuário.
     * 
     * @return a idade do usuário
     */
    public int getIdade() {
        return idade;
    }

    /**
     * Define a idade do usuário.
     * 
     * @param idade a idade do usuário
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Obtém o endereço associado ao usuário.
     * 
     * @return o endereço associado ao usuário
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Define o endereço associado ao usuário.
     * 
     * @param endereco o endereço associado ao usuário
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * Representa uma string contendo as informações do usuário.
     * 
     * @return uma string com o ID, nome, e-mail, idade e o endereço do usuário
     */
    @Override
    public String toString() {
        return "ID: " + id + " Nome: " + nomeCompleto + ", Email: " + email + ", Idade: " + idade + ", [" + endereco + "]";
    }
}

package br.edu.infnet.appMatheusAvelino.model.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * Representa um endereço no sistema.
 * <p>
 * Esta classe é mapeada para a tabela "TEndereco" no banco de dados.
 * </p>
 */
@Entity
@Table(name = "TEndereco")
public class Endereco {

    /**
     * Identificador único do endereço.
     * <p>
     * A geração do valor do ID será feita automaticamente pelo banco de dados.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Código de Endereçamento Postal (CEP).
     * <p>
     * Deve ter no máximo 10 caracteres.
     * </p>
     */
    @Size(max = 10, message = "O tipo de CEP deve ter no máximo 10 caracteres.")
    private String cep;

    /**
     * Logradouro do endereço, como rua, avenida, etc.
     * <p>
     * Deve ter no máximo 50 caracteres.
     * </p>
     */
    @Size(max = 50, message = "O tipo de LOGRADOURO deve ter no máximo 50 caracteres.")
    private String logradouro;

    /**
     * Complemento do endereço, como número do apartamento ou bloco.
     * <p>
     * Deve ter no máximo 20 caracteres.
     * </p>
     */
    @Size(max = 20, message = "O tipo de COMPLEMENTO deve ter no máximo 20 caracteres.")
    private String complemento;

    /**
     * Bairro onde o endereço está localizado.
     * <p>
     * Deve ter no máximo 20 caracteres.
     * </p>
     */
    @Size(max = 20, message = "O tipo de BAIRRO deve ter no máximo 20 caracteres.")
    private String bairro;

    /**
     * Localidade, geralmente a cidade onde o endereço está localizado.
     * <p>
     * Deve ter no máximo 20 caracteres.
     * </p>
     */
    @Size(max = 20, message = "O tipo de LOCALIDADE deve ter no máximo 20 caracteres.")
    private String localidade;

    /**
     * Unidade Federativa (UF) do endereço, representando o estado.
     * <p>
     * Deve ter no máximo 2 caracteres.
     * </p>
     */
    @Size(max = 2, message = "O tipo de UF deve ter no máximo 2 caracteres.")
    private String uf;

    /**
     * Obtém o identificador único do endereço.
     * 
     * @return o ID do endereço
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador único do endereço.
     * 
     * @param id o ID do endereço
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o código de Endereçamento Postal (CEP).
     * 
     * @return o CEP do endereço
     */
    public String getCep() {
        return cep;
    }

    /**
     * Define o código de Endereçamento Postal (CEP).
     * 
     * @param cep o CEP do endereço
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Obtém o logradouro do endereço.
     * 
     * @return o logradouro do endereço
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Define o logradouro do endereço.
     * 
     * @param logradouro o logradouro do endereço
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * Obtém o complemento do endereço.
     * 
     * @return o complemento do endereço
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * Define o complemento do endereço.
     * 
     * @param complemento o complemento do endereço
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * Obtém o bairro do endereço.
     * 
     * @return o bairro do endereço
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * Define o bairro do endereço.
     * 
     * @param bairro o bairro do endereço
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * Obtém a localidade do endereço.
     * 
     * @return a localidade do endereço
     */
    public String getLocalidade() {
        return localidade;
    }

    /**
     * Define a localidade do endereço.
     * 
     * @param localidade a localidade do endereço
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    /**
     * Obtém a Unidade Federativa (UF) do endereço.
     * 
     * @return a UF do endereço
     */
    public String getUf() {
        return uf;
    }

    /**
     * Define a Unidade Federativa (UF) do endereço.
     * 
     * @param uf a UF do endereço
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Representa uma string contendo as informações do endereço.
     * 
     * @return uma string com os detalhes do endereço
     */
    @Override
    public String toString() {
        return "Endereco{ ID:" + id + ", CEP:" + cep + ", Logradouro:" + logradouro + ", Complemento:" + complemento
                + ", Bairro:" + bairro + ", Localidade:" + localidade + ", UF:" + uf + "}";
    }
}

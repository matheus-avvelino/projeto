package br.edu.infnet.appMatheusAvelino.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMatheusAvelino.client.EnderecoClient;
import br.edu.infnet.appMatheusAvelino.model.domain.Endereco;

/**
 * Serviço responsável pela gestão de endereços no sistema.
 * 
 * <p>Este serviço utiliza o {@link EnderecoClient} para interagir com um serviço externo que fornece
 * informações de endereços com base no CEP.</p>
 * 
 * <p>O serviço oferece um método para buscar um endereço com base no CEP fornecido.</p>
 * 
 * @see EnderecoClient
 * @see Endereco
 */
@Service
public class EnderecoService {
    
    /**
     * Cliente usado para acessar o serviço externo de endereços.
     */
    @Autowired
    private EnderecoClient enderecoClient;

    /**
     * Obtém um endereço com base no CEP fornecido.
     * 
     * <p>Este método faz uma chamada ao {@link EnderecoClient} para recuperar o endereço correspondente
     * ao CEP informado.</p>
     * 
     * @param cep O CEP do endereço a ser buscado. Não deve ser nulo ou vazio.
     * @return O {@link Endereco} correspondente ao CEP fornecido. Pode ser null se nenhum endereço for encontrado.
     */
    public Endereco obterPorCep(String cep) {
        return enderecoClient.findByCep(cep);
    }
}

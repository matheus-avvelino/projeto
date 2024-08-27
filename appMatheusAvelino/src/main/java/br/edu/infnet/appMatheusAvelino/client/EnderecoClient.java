package br.edu.infnet.appMatheusAvelino.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.appMatheusAvelino.model.domain.Endereco;

/**
 * Cliente Feign para interagir com o serviço externo de busca de endereços via CEP.
 * <p>
 * Utiliza a API do ViaCEP para buscar informações de endereço com base no CEP fornecido.
 * </p>
 */
@FeignClient(url="https://viacep.com.br/ws", name="enderecoClient")
public interface EnderecoClient {

    /**
     * Busca o endereço correspondente ao CEP fornecido.
     * <p>
     * Mapeia uma requisição GET para a URL "/{cep}/json/" no serviço ViaCEP.
     * </p>
     * 
     * @param cep o CEP do endereço a ser consultado
     * @return o objeto {@link Endereco} com as informações do endereço
     */
    @GetMapping(value = "/{cep}/json/")
    Endereco findByCep(@PathVariable String cep);
}

package br.edu.infnet.appMatheusAvelino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMatheusAvelino.model.domain.Abordagem;
import br.edu.infnet.appMatheusAvelino.model.service.AbordagemService;

/**
 * Controlador REST para gerenciar as requisições relacionadas à entidade Abordagem.
 * <p>
 * Esta classe fornece endpoints para listar, obter, incluir e excluir abordagens.
 * </p>
 */
@RestController
public class AbordagemController {

    /**
     * Serviço para manipulação dos dados de abordagem, injetado automaticamente.
     */
    @Autowired
    private AbordagemService abordagemService;

    /**
     * Manipula uma requisição GET para a URL "abordagem/listar".
     * <p>
     * Retorna uma lista de todas as abordagens disponíveis.
     * </p>
     * 
     * @return uma lista de objetos {@link Abordagem} disponíveis
     */
    @GetMapping(value = "abordagem/listar")
    public Iterable<Abordagem> obterLista() {
        return abordagemService.obterLista();
    }

    /**
     * Manipula uma requisição GET para a URL "abordagem/{id}".
     * <p>
     * Retorna um objeto Abordagem específico baseado no ID fornecido.
     * </p>
     * 
     * @param id o ID da abordagem a ser retornada
     * @return o objeto {@link Abordagem} correspondente ao ID fornecido
     */
    @GetMapping(value = "abordagem/{id}")
    public Abordagem obterPorId(@PathVariable Integer id) {
        return abordagemService.obterPorId(id);
    }

    /**
     * Manipula uma requisição POST para a URL "abordagem/incluir".
     * <p>
     * O corpo da requisição deve conter um objeto Abordagem em formato JSON.
     * Inclui a nova abordagem e retorna uma mensagem de sucesso.
     * </p>
     * 
     * @param abordagem o objeto {@link Abordagem} a ser incluído
     * @return uma mensagem indicando o sucesso da inclusão
     */
    @PostMapping(value = "abordagem/incluir")
    public String incluir(@RequestBody Abordagem abordagem) {
        abordagemService.incluir(abordagem);
        return "Inclusão:" + abordagem + ", efetuada com sucesso";
    }

    /**
     * Manipula uma requisição DELETE para a URL "abordagem/{id}/excluir".
     * <p>
     * Exclui a abordagem com o ID especificado e retorna uma mensagem de sucesso.
     * </p>
     * 
     * @param id o ID da abordagem a ser excluída
     * @return uma mensagem indicando o sucesso da exclusão
     */
    @DeleteMapping(value = "abordagem/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        abordagemService.excluir(id);
        return "Exclusão do id : " + id + ", efetuada com sucesso.";
    }

}

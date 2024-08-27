package br.edu.infnet.appMatheusAvelino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMatheusAvelino.model.domain.Atendimento;
import br.edu.infnet.appMatheusAvelino.model.service.AtendimentoService;

/**
 * Controlador REST para gerenciar as operações relacionadas à entidade Atendimento.
 * <p>
 * Esta classe responde às solicitações HTTP e delega as operações para o serviço {@link AtendimentoService}.
 * </p>
 */
@RestController
public class AtendimentoController {
	
    /**
     * Instância do serviço `AtendimentoService`, injetada automaticamente pelo Spring.
     */
    @Autowired
    private AtendimentoService atendimentoService;

    /**
     * Manipula uma requisição GET para listar todos os atendimentos.
     * 
     * @return uma lista de todos os objetos {@link Atendimento} disponíveis
     */
    @GetMapping(value = "atendimento/listar")
    public Iterable<Atendimento> obterLista() {
        return atendimentoService.obterLista();
    }
	
    /**
     * Manipula uma requisição GET para obter um atendimento específico pelo ID.
     * 
     * @param id o identificador do atendimento
     * @return o objeto {@link Atendimento} correspondente ao ID fornecido
     */
    @GetMapping(value = "atendimento/{id}")
    public Atendimento obterPorId(@PathVariable Integer id) {
        return atendimentoService.obterPorId(id);
    }

    /**
     * Manipula uma requisição POST para incluir um novo atendimento.
     * <p>
     * O corpo da requisição deve conter um objeto {@link Atendimento} em formato JSON.
     * </p>
     * 
     * @param atendimento o objeto {@link Atendimento} a ser incluído
     * @return uma mensagem de sucesso após a inclusão do atendimento
     */
    @PostMapping(value = "atendimento/incluir")
    public String incluir(@RequestBody Atendimento atendimento) {
        atendimentoService.incluir(atendimento);
        return "Inclusão:" + atendimento + ", efetuada com sucesso";
    }
	
    /**
     * Manipula uma requisição DELETE para excluir um atendimento específico pelo ID.
     * 
     * @param id o identificador do atendimento a ser excluído
     * @return uma mensagem de sucesso após a exclusão do atendimento
     */
    @DeleteMapping(value = "atendimento/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        atendimentoService.excluir(id);
        return "Exclusão do id : "+ id + ", efetuada com sucesso.";
    }
}

package br.edu.infnet.appMatheusAvelino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMatheusAvelino.model.domain.Psicologo;
import br.edu.infnet.appMatheusAvelino.model.service.PsicologoService;

/**
 * Controlador REST para gerenciar as operações relacionadas à entidade Psicologo.
 * <p>
 * Esta classe responde às solicitações HTTP e delega as operações para o serviço {@link PsicologoService}.
 * </p>
 */
@RestController
public class PsicologoController {

    /**
     * Instância do serviço `PsicologoService`, injetada automaticamente pelo Spring.
     */
    @Autowired
    private PsicologoService psicologoService;

    /**
     * Manipula uma requisição GET para listar todos os psicólogos.
     * 
     * @return uma lista de todos os objetos {@link Psicologo} disponíveis
     */
    @GetMapping(value = "psicologo/listar")
    public Iterable<Psicologo> obterLista() {
        return psicologoService.obterLista();
    }
    
    /**
     * Manipula uma requisição GET para obter um psicólogo específico pelo ID.
     * 
     * @param id o identificador do psicólogo
     * @return o objeto {@link Psicologo} correspondente ao ID fornecido
     */
    @GetMapping(value = "psicologo/{id}")
    public Psicologo obterPorId(@PathVariable Integer id) {
        return psicologoService.obterPorId(id);
    }

    /**
     * Manipula uma requisição POST para incluir um novo psicólogo.
     * <p>
     * O corpo da requisição deve conter um objeto {@link Psicologo} em formato JSON.
     * </p>
     * 
     * @param psicologo o objeto {@link Psicologo} a ser incluído
     * @return uma mensagem de sucesso após a inclusão do psicólogo
     */
    @PostMapping(value = "psicologo/incluir")
    public String incluir(@RequestBody Psicologo psicologo) {
        psicologoService.incluir(psicologo);
        return "Inclusão:" + psicologo + ", efetuada com sucesso";
    }
    
    /**
     * Manipula uma requisição DELETE para excluir um psicólogo específico pelo ID.
     * 
     * @param id o identificador do psicólogo a ser excluído
     * @return uma mensagem de sucesso após a exclusão do psicólogo
     */
    @DeleteMapping(value = "psicologo/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        psicologoService.excluir(id);
        return "Exclusão do id : "+ id + ", efetuada com sucesso.";
    }
}

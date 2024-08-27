package br.edu.infnet.appMatheusAvelino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appMatheusAvelino.model.domain.Paciente;
import br.edu.infnet.appMatheusAvelino.model.service.PacienteService;

/**
 * Controlador REST para gerenciar as operações relacionadas à entidade Paciente.
 * <p>
 * Esta classe responde às solicitações HTTP e delega as operações para o serviço {@link PacienteService}.
 * </p>
 */
@RestController
public class PacienteController {
	
    /**
     * Instância do serviço `PacienteService`, injetada automaticamente pelo Spring.
     */
    @Autowired
    private PacienteService pacienteService;

    /**
     * Manipula uma requisição GET para listar todos os pacientes.
     * 
     * @return uma lista de todos os objetos {@link Paciente} disponíveis
     */
    @GetMapping(value = "paciente/listar")
    public Iterable<Paciente> obterLista() {
        return pacienteService.obterLista();
    }

    /**
     * Manipula uma requisição GET para obter um paciente específico pelo ID.
     * 
     * @param id o identificador do paciente
     * @return o objeto {@link Paciente} correspondente ao ID fornecido
     */
    @GetMapping(value = "paciente/{id}")
    public Paciente obterPorId(@PathVariable Integer id) {
        return pacienteService.obterPorId(id);
    }

    /**
     * Manipula uma requisição POST para incluir um novo paciente.
     * <p>
     * O corpo da requisição deve conter um objeto {@link Paciente} em formato JSON.
     * </p>
     * 
     * @param paciente o objeto {@link Paciente} a ser incluído
     * @return uma mensagem de sucesso após a inclusão do paciente
     */
    @PostMapping(value = "paciente/incluir")
    public String incluir(@RequestBody Paciente paciente) {
        pacienteService.incluir(paciente);
        return "Inclusão:" + paciente + ", efetuada com sucesso";
    }
	
    /**
     * Manipula uma requisição DELETE para excluir um paciente específico pelo ID.
     * 
     * @param id o identificador do paciente a ser excluído
     * @return uma mensagem de sucesso após a exclusão do paciente
     */
    @DeleteMapping(value = "paciente/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        pacienteService.excluir(id);
        return "Exclusão do id : "+ id + ", efetuada com sucesso.";
    }
}

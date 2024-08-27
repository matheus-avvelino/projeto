package br.edu.infnet.appMatheusAvelino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.appMatheusAvelino.model.service.AbordagemService;
import br.edu.infnet.appMatheusAvelino.model.service.AtendimentoService;
import br.edu.infnet.appMatheusAvelino.model.service.PacienteService;
import br.edu.infnet.appMatheusAvelino.model.service.PsicologoService;
import br.edu.infnet.appMatheusAvelino.model.service.UsuarioService;

/**
 * Controlador Spring MVC para gerenciar as requisições da camada de visualização.
 * <p>
 * Esta classe lida com as requisições HTTP e prepara os dados necessários para as views, utilizando os serviços injetados.
 * </p>
 */
@Controller
public class AppController {

    /**
     * Serviço para manipulação dos dados de usuário, injetado automaticamente.
     */
    @Autowired
    private UsuarioService usuarioService;
	
    /**
     * Serviço para manipulação dos dados de psicólogo, injetado automaticamente.
     */
    @Autowired
    private PsicologoService psicologoService;
	
    /**
     * Serviço para manipulação dos dados de paciente, injetado automaticamente.
     */
    @Autowired
    private PacienteService pacienteService;
	
    /**
     * Serviço para manipulação dos dados de abordagem, injetado automaticamente.
     */
    @Autowired
    private AbordagemService abordagemService;
	
    /**
     * Serviço para manipulação dos dados de atendimento, injetado automaticamente.
     */
    @Autowired
    private AtendimentoService atendimentoService;

    /**
     * Manipula uma requisição GET para a URL "/".
     * <p>
     * Adiciona ao modelo as quantidades de cada entidade (usuário, psicólogo, paciente, abordagem e atendimento)
     * para serem exibidas na página inicial.
     * </p>
     * 
     * @param model o modelo para adicionar atributos que serão utilizados na view
     * @return o nome da view que será renderizada, neste caso, "home"
     */
    @GetMapping(value = "/")
    public String telaHome(Model model) {
        model.addAttribute("qtdeUsuario", usuarioService.obterQtde());
        model.addAttribute("qtdePsicologo", psicologoService.obterQtde());
        model.addAttribute("qtdePaciente", pacienteService.obterQtde());
        model.addAttribute("qtdeAbordagem", abordagemService.obterQtde());
        model.addAttribute("qtdeAtendimento", atendimentoService.obterQtde());
        return "home";
    }
	
    /**
     * Manipula uma requisição GET para a URL "/usuario/listagem".
     * <p>
     * Prepara a listagem de usuários para ser exibida na página.
     * </p>
     * 
     * @param model o modelo para adicionar atributos que serão utilizados na view
     * @return o nome da view que será renderizada, chamando o método {@link #telaHome(Model)}
     */
    @GetMapping(value = "/usuario/listagem")
    public String listarUsuario(Model model) {
        model.addAttribute("titulo", "Listagem de usuarios");
        model.addAttribute("listagem", usuarioService.obterLista("nomeCompleto"));
        return telaHome(model);
    }
	
    /**
     * Manipula uma requisição GET para a URL "/psicologo/listagem".
     * <p>
     * Prepara a listagem de psicólogos para ser exibida na página.
     * </p>
     * 
     * @param model o modelo para adicionar atributos que serão utilizados na view
     * @return o nome da view que será renderizada, chamando o método {@link #telaHome(Model)}
     */
    @GetMapping(value = "/psicologo/listagem")
    public String listarPsicologo(Model model) {
        model.addAttribute("titulo", "Listagem de psicologos");
        model.addAttribute("listagem", psicologoService.obterLista("idade"));
        return telaHome(model);
    }

    /**
     * Manipula uma requisição GET para a URL "/paciente/listagem".
     * <p>
     * Prepara a listagem de pacientes para ser exibida na página.
     * </p>
     * 
     * @param model o modelo para adicionar atributos que serão utilizados na view
     * @return o nome da view que será renderizada, chamando o método {@link #telaHome(Model)}
     */
    @GetMapping(value = "/paciente/listagem")
    public String listarPaciente(Model model) {
        model.addAttribute("titulo", "Listagem de pacientes");
        model.addAttribute("listagem", pacienteService.obterLista("idade"));
        return telaHome(model);
    }

    /**
     * Manipula uma requisição GET para a URL "/abordagem/listagem".
     * <p>
     * Prepara a listagem de abordagens para ser exibida na página.
     * </p>
     * 
     * @param model o modelo para adicionar atributos que serão utilizados na view
     * @return o nome da view que será renderizada, chamando o método {@link #telaHome(Model)}
     */
    @GetMapping(value = "/abordagem/listagem")
    public String listarAbordagem(Model model) {
        model.addAttribute("titulo", "Listagem de abordagens");
        model.addAttribute("listagem", abordagemService.obterLista("descricao"));
        return telaHome(model);
    }

    /**
     * Manipula uma requisição GET para a URL "/atendimento/listagem".
     * <p>
     * Prepara a listagem de atendimentos para ser exibida na página.
     * </p>
     * 
     * @param model o modelo para adicionar atributos que serão utilizados na view
     * @return o nome da view que será renderizada, chamando o método {@link #telaHome(Model)}
     */
    @GetMapping(value = "/atendimento/listagem")
    public String listarAtendimento(Model model) {
        model.addAttribute("titulo", "Listagem de atendimentos");
        model.addAttribute("listagem", atendimentoService.obterLista("statusAtendimento"));
        return telaHome(model);
    }
}

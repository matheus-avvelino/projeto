package br.edu.infnet.appMatheusAvelino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMatheusAvelino.model.domain.Usuario;
import br.edu.infnet.appMatheusAvelino.model.service.UsuarioService;

/**
 * Componente responsável por carregar e exibir informações de usuários na inicialização da aplicação.
 * <p>
 * Implementa a interface {@link ApplicationRunner} para executar um código adicional
 * após a inicialização da aplicação Spring Boot. Neste caso, é utilizado para obter e 
 * exibir usuários com 30 anos de idade.
 * </p>
 */
@Component
public class UsuarioLoader implements ApplicationRunner {

    /**
     * Serviço para manipular dados de {@link Usuario}.
     */
    @Autowired
    private UsuarioService usuarioService;

    /**
     * Executa a lógica de carregamento de dados após a inicialização da aplicação.
     * <p>
     * Obtém todos os usuários com 30 anos de idade e imprime suas informações no console.
     * </p>
     * 
     * @param args argumentos de inicialização da aplicação.
     * @throws Exception caso ocorra algum erro durante a execução.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (Usuario u : usuarioService.obterPorIdade(30)) {
            System.err.println("[USUARIOS COM 30 ANOS] " + u);
        }
    }
}

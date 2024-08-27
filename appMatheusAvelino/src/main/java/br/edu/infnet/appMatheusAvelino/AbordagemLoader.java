package br.edu.infnet.appMatheusAvelino;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMatheusAvelino.model.domain.Abordagem;
import br.edu.infnet.appMatheusAvelino.model.service.AbordagemService;

/**
 * Classe responsável por carregar e processar dados de abordagens a partir de um arquivo de texto.
 * <p>
 * A anotação {@link Component} define a classe como um componente Spring, que será gerenciado pelo
 * contexto da aplicação.
 * </p>
 * <p>
 * A anotação {@link Order} define a ordem de execução do loader, onde valores menores indicam uma prioridade mais alta.
 * Neste caso, {@code @Order(1)} indica que esta classe deve ser executada antes dos outros loaders.
 * </p>
 */
@Component
@Order(1)
public class AbordagemLoader implements ApplicationRunner {

    @Autowired
    private AbordagemService abordagemService;

    /**
     * Método que carrega dados de abordagens a partir de um arquivo e os salva no serviço de abordagem.
     * <p>
     * Lê o arquivo "files/abordagem.txt", processa cada linha para criar instâncias de {@link Abordagem}, e
     * as inclui no serviço {@link AbordagemService}.
     * </p>
     * 
     * @param args Argumentos da linha de comando fornecidos para a aplicação.
     * @throws Exception Caso ocorra algum erro durante a leitura do arquivo ou processamento dos dados.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (FileReader file = new FileReader("files/abordagem.txt");
             BufferedReader leitura = new BufferedReader(file)) {
             
            String linha;

            while ((linha = leitura.readLine()) != null) {
                String[] campos = linha.split(";");

                String descricao = campos[0].trim();

                Abordagem abordagem = new Abordagem(descricao);
                abordagemService.incluir(abordagem);
            }

            for (Abordagem e : abordagemService.obterLista()) {
                System.out.println("[ABORDAGEM] " + e);
            }
        }
    }
}

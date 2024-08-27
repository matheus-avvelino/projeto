package br.edu.infnet.appMatheusAvelino;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMatheusAvelino.model.domain.Endereco;
import br.edu.infnet.appMatheusAvelino.model.domain.Psicologo;
import br.edu.infnet.appMatheusAvelino.model.service.AbordagemService;
import br.edu.infnet.appMatheusAvelino.model.service.EnderecoService;
import br.edu.infnet.appMatheusAvelino.model.service.PsicologoService;

/**
 * Componente responsável por carregar psicólogos a partir de um arquivo de texto na inicialização da aplicação.
 * <p>
 * Implementa a interface {@link ApplicationRunner} para executar a lógica de carregamento de dados após a inicialização
 * da aplicação Spring Boot. Neste caso, a classe lê um arquivo com informações de psicólogos e os salva no banco de dados.
 * </p>
 */
@Component
@Order(2)
public class PsicologoLoader implements ApplicationRunner {

    /**
     * Serviço para manipular dados de {@link Psicologo}.
     */
    @Autowired
    private PsicologoService psicologoService;

    /**
     * Serviço para manipular dados de {@link Abordagem}.
     */
    @Autowired
    private AbordagemService abordagemService;

    /**
     * Serviço para manipular dados de {@link Endereco}.
     */
    @Autowired
    private EnderecoService enderecoService;

    /**
     * Executa a lógica de carregamento de dados após a inicialização da aplicação.
     * <p>
     * Lê um arquivo de texto contendo informações sobre psicólogos, cria instâncias de {@link Psicologo} e as salva
     * no banco de dados. Também imprime informações sobre os psicólogos carregados e busca um psicólogo específico
     * pelo CRP.
     * </p>
     * 
     * @param args argumentos de inicialização da aplicação.
     * @throws Exception caso ocorra algum erro durante a leitura do arquivo ou a inclusão dos dados.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Abre o arquivo de texto contendo informações dos psicólogos
        FileReader file = new FileReader("files/psicologo.txt");
        BufferedReader leitura = new BufferedReader(file);
        String linha;

        // Lê cada linha do arquivo e processa os dados
        while ((linha = leitura.readLine()) != null) {

            // Divide a linha em campos usando o delimitador ";"
            String[] campos = linha.split(";");

            // Obtém o endereço pelo CEP
            Endereco endereco = enderecoService.obterPorCep(campos[5].trim());

            // Cria uma instância de Psicologo com os dados lidos
            String nomeCompleto = campos[0].trim();
            String email = campos[1].trim();
            int idade = Integer.parseInt(campos[2].trim());
            String CRP = campos[3].trim();
            int idAbordagem = Integer.parseInt(campos[4].trim());

            Psicologo psicologo = new Psicologo(nomeCompleto, email, idade, CRP,
                    abordagemService.obterPorId(idAbordagem));
            psicologo.setEndereco(endereco);
            psicologoService.incluir(psicologo);
        }

        // Imprime todos os psicólogos no console
        for (Psicologo p : psicologoService.obterLista()) {
            System.out.println("[PSICOLOGO] " + p);
        }

        // Busca e imprime um psicólogo específico pelo CRP
        String crp = "123456";
        Psicologo p1 = psicologoService.obterPorCrp(crp);
        System.err.println("[PSICOLOGO POR CRP ]" + p1);

        // Fecha o BufferedReader
        leitura.close();
    }
}

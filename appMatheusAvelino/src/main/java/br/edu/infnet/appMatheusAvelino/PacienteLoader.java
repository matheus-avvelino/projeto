package br.edu.infnet.appMatheusAvelino;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMatheusAvelino.model.domain.Endereco;
import br.edu.infnet.appMatheusAvelino.model.domain.Paciente;
import br.edu.infnet.appMatheusAvelino.model.service.EnderecoService;
import br.edu.infnet.appMatheusAvelino.model.service.PacienteService;

/**
 * Componente responsável por carregar pacientes a partir de um arquivo de texto na inicialização da aplicação.
 * <p>
 * Implementa a interface {@link ApplicationRunner} para executar a lógica de carregamento de dados após a inicialização
 * da aplicação Spring Boot. Neste caso, a classe lê um arquivo com informações de pacientes e os salva no banco de dados.
 * </p>
 */
@Component
@Order(3)
public class PacienteLoader implements ApplicationRunner {

    /**
     * Serviço para manipular dados de {@link Paciente}.
     */
    @Autowired
    private PacienteService pacienteService;

    /**
     * Serviço para manipular dados de {@link Endereco}.
     */
    @Autowired
    private EnderecoService enderecoService;

    /**
     * Executa a lógica de carregamento de dados após a inicialização da aplicação.
     * <p>
     * Lê um arquivo de texto contendo informações sobre pacientes, cria instâncias de {@link Paciente} e as salva
     * no banco de dados. Também imprime informações sobre os pacientes carregados e busca um paciente específico
     * pelo CPF.
     * </p>
     * 
     * @param args argumentos de inicialização da aplicação.
     * @throws Exception caso ocorra algum erro durante a leitura do arquivo ou a inclusão dos dados.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Abre o arquivo de texto contendo informações dos pacientes
        FileReader file = new FileReader("files/paciente.txt");
        BufferedReader leitura = new BufferedReader(file);
        String linha;

        // Lê cada linha do arquivo e processa os dados
        while ((linha = leitura.readLine()) != null) {

            // Divide a linha em campos usando o delimitador ";"
            String[] campos = linha.split(";");

            // Obtém o endereço pelo CEP
            Endereco endereco = enderecoService.obterPorCep(campos[4].trim());

            // Cria uma instância de Paciente com os dados lidos
            String nomeCompleto = campos[0].trim();
            String email = campos[1].trim();
            int idade = Integer.parseInt(campos[2].trim());
            String cpf = campos[3].trim();

            Paciente paciente = new Paciente(nomeCompleto, email, idade, cpf);
            paciente.setEndereco(endereco);
            pacienteService.incluir(paciente);
        }

        // Imprime todos os pacientes no console
        for (Paciente p : pacienteService.obterLista()) {
            System.out.println("[PACIENTE] " + p);
        }

        // Busca e imprime um paciente específico pelo CPF
        Paciente p1 = pacienteService.obterPorCpf("12345678964");
        System.err.println("[PACIENTE POR CPF] " + p1);

        // Fecha o BufferedReader
        leitura.close();
    }
}

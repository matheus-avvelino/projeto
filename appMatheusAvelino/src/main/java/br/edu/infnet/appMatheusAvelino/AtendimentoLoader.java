package br.edu.infnet.appMatheusAvelino;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appMatheusAvelino.model.domain.Atendimento;
import br.edu.infnet.appMatheusAvelino.model.domain.Paciente;
import br.edu.infnet.appMatheusAvelino.model.domain.Psicologo;
import br.edu.infnet.appMatheusAvelino.model.service.AtendimentoService;

/**
 * Componente responsável por carregar atendimentos a partir de um arquivo de texto na inicialização da aplicação.
 * <p>
 * Implementa a interface {@link ApplicationRunner} para executar a lógica de carregamento de dados após a inicialização
 * da aplicação Spring Boot. Neste caso, a classe lê um arquivo com informações de atendimentos e os salva no banco de dados.
 * </p>
 */
@Component
@Order(4)
public class AtendimentoLoader implements ApplicationRunner {

    /**
     * Serviço para manipular dados de {@link Atendimento}.
     */
    @Autowired
    private AtendimentoService atendimentoService;

    /**
     * Executa a lógica de carregamento de dados após a inicialização da aplicação.
     * <p>
     * Lê um arquivo de texto contendo informações sobre atendimentos, cria instâncias de {@link Atendimento} e as salva
     * no banco de dados. Também imprime informações sobre os atendimentos carregados e os separa por status.
     * </p>
     * 
     * @param args argumentos de inicialização da aplicação.
     * @throws Exception caso ocorra algum erro durante a leitura do arquivo ou a inclusão dos dados.
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Abre o arquivo de texto contendo informações dos atendimentos
        FileReader file = new FileReader("files/atendimento.txt");
        BufferedReader leitura = new BufferedReader(file);
        String linha;

        // Lê cada linha do arquivo e processa os dados
        while ((linha = leitura.readLine()) != null) {
            // Divide a linha em campos usando o delimitador ";"
            String[] campos = linha.split(";");

            // Cria instâncias de Psicologo e Paciente
            Psicologo psicologo = new Psicologo();
            Paciente paciente = new Paciente();

            // Obtém os dados dos campos e cria uma instância de Atendimento
            Integer psicologoId = Integer.parseInt(campos[0].trim());
            Integer pacienteId = Integer.parseInt(campos[1].trim());
            String data = campos[2].trim();
            String tipoAtendimento = campos[3].trim();
            Boolean statusAtendimento = Boolean.valueOf(campos[4].trim());

            Atendimento atendimento = new Atendimento(data, tipoAtendimento);
            psicologo.setId(psicologoId);
            paciente.setId(pacienteId);

            atendimento.setPsicologo(psicologo);
            atendimento.setPaciente(paciente);
            atendimento.setStatusAtendimento(statusAtendimento);

            // Inclui o atendimento no banco de dados
            atendimentoService.incluir(atendimento);
        }

        // Imprime todos os atendimentos no console
        for (Atendimento a : atendimentoService.obterLista()) {
            System.out.println("[Atendimentos]: " + a);
        }

        // Imprime atendimentos com status "efetuado"
        for (Atendimento a : atendimentoService.obterPorStatusAtendimento(true)) {
            System.err.println("[ATENDIMENTOS EFETUADO] " + a);
        }

        // Imprime atendimentos com status "em andamento"
        for (Atendimento a : atendimentoService.obterPorStatusAtendimento(false)) {
            System.err.println("[ATENDIMENTOS EM ANDAMENTO] " + a);
        }

        // Fecha o BufferedReader
        leitura.close();
    }
}

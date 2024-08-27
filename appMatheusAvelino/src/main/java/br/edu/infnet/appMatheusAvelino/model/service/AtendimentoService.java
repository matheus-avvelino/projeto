package br.edu.infnet.appMatheusAvelino.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMatheusAvelino.model.domain.Atendimento;
import br.edu.infnet.appMatheusAvelino.model.repository.AtendimentoRepository;

/**
 * Serviço responsável pela gestão dos atendimentos no sistema.
 * Fornece operações para incluir, listar, obter por ID, excluir e contar atendimentos.
 * Também oferece a capacidade de filtrar atendimentos com base no status de atendimento.
 * 
 * <p>Este serviço utiliza o repositório {@link AtendimentoRepository} para realizar operações de
 * persistência e recuperação de dados.</p>
 * 
 * <p>Os métodos dessa classe podem lançar exceções durante operações de inclusão, caso haja
 * falhas na comunicação com o banco de dados.</p>
 * 
 * @see Atendimento
 * @see AtendimentoRepository
 */
@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    /**
     * Inclui um novo atendimento no banco de dados.
     *
     * @param atendimento O atendimento a ser incluído. Não deve ser nulo.
     */
    public void incluir(Atendimento atendimento) {
        try {
            atendimentoRepository.save(atendimento);
        } catch (Exception e) {
            System.err.println("[Error] " + e.getMessage());
        }
    }

    /**
     * Obtém todos os atendimentos registrados no banco de dados.
     *
     * @return Um iterable contendo todos os atendimentos.
     */
    public Iterable<Atendimento> obterLista() {
        return atendimentoRepository.findAll();
    }

    /**
     * Obtém todos os atendimentos, ordenados pelo atributo especificado.
     *
     * @param orderBy O atributo pelo qual os atendimentos serão ordenados. Não deve ser nulo.
     * @return Um iterable contendo todos os atendimentos, ordenados conforme o atributo especificado.
     */
    public Iterable<Atendimento> obterLista(String orderBy) {
        return atendimentoRepository.findAll(Sort.by(Sort.Direction.DESC, orderBy));
    }

    /**
     * Obtém um atendimento específico com base no ID fornecido.
     *
     * @param id O ID do atendimento a ser obtido. Deve ser um número positivo.
     * @return O atendimento correspondente ao ID fornecido, ou null se nenhum atendimento for encontrado.
     */
    public Atendimento obterPorId(Integer id) {
        return atendimentoRepository.findById(id).orElse(null);
    }

    /**
     * Exclui um atendimento com base no ID fornecido.
     *
     * @param id O ID do atendimento a ser excluído. Deve ser um número positivo.
     */
    public void excluir(Integer id) {
        atendimentoRepository.deleteById(id);
    }

    /**
     * Obtém a quantidade total de atendimentos registrados no banco de dados.
     *
     * @return O número total de atendimentos.
     */
    public long obterQtde() {
        return atendimentoRepository.count();
    }

    /**
     * Obtém uma coleção de atendimentos com base no status fornecido.
     *
     * @param statusAtendimento O status do atendimento a ser filtrado. Pode ser true ou false.
     * @return Uma coleção de atendimentos que correspondem ao status fornecido.
     */
    public Collection<Atendimento> obterPorStatusAtendimento(boolean statusAtendimento) {
        return atendimentoRepository.findBystatusAtendimento(statusAtendimento);
    }
}

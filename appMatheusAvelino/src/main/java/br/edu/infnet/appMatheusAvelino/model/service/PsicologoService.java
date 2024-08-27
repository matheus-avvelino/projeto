package br.edu.infnet.appMatheusAvelino.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMatheusAvelino.model.domain.Psicologo;
import br.edu.infnet.appMatheusAvelino.model.repository.PsicologoRepository;

/**
 * Serviço responsável pela gestão de psicólogos no sistema.
 * 
 * <p>Este serviço fornece métodos para realizar operações de persistência e recuperação de dados
 * relacionados a psicólogos, utilizando o {@link PsicologoRepository} para interagir com o banco de dados.</p>
 * 
 * @see Psicologo
 * @see PsicologoRepository
 */
@Service
public class PsicologoService {

    /**
     * Repositório usado para operações de persistência e recuperação de dados de psicólogos.
     */
    @Autowired
    private PsicologoRepository psicologoRepository;

    /**
     * Inclui um novo psicólogo na base de dados.
     * 
     * <p>Este método salva o psicólogo fornecido no repositório. Caso ocorra uma exceção durante a operação,
     * a mensagem de erro é exibida no console.</p>
     * 
     * @param psicologo O psicólogo a ser incluído. Não deve ser nulo.
     */
    public void incluir(Psicologo psicologo) {
        try {
            psicologoRepository.save(psicologo);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    /**
     * Obtém a lista completa de psicólogos.
     * 
     * <p>Este método recupera todos os psicólogos armazenados no repositório.</p>
     * 
     * @return Um {@link Iterable} contendo todos os psicólogos.
     */
    public Iterable<Psicologo> obterLista() {
        return psicologoRepository.findAll();
    }

    /**
     * Obtém a lista de psicólogos ordenada por um atributo específico.
     * 
     * <p>Este método recupera todos os psicólogos e os ordena de acordo com o atributo especificado.</p>
     * 
     * @param orderBy O nome do atributo pelo qual os psicólogos devem ser ordenados. Não deve ser nulo ou vazio.
     * @return Um {@link Iterable} contendo todos os psicólogos ordenados conforme o atributo fornecido.
     */
    public Iterable<Psicologo> obterLista(String orderBy) {
        return psicologoRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
    }

    /**
     * Obtém um psicólogo pelo ID.
     * 
     * <p>Este método recupera um psicólogo com base no ID fornecido. Se o psicólogo não for encontrado, retorna null.</p>
     * 
     * @param id O ID do psicólogo a ser recuperado. Não deve ser nulo.
     * @return O {@link Psicologo} correspondente ao ID fornecido, ou null se nenhum psicólogo for encontrado.
     */
    public Psicologo obterPorId(Integer id) {
        return psicologoRepository.findById(id).orElse(null);
    }

    /**
     * Exclui um psicólogo pelo ID.
     * 
     * <p>Este método remove o psicólogo com o ID especificado do repositório.</p>
     * 
     * @param id O ID do psicólogo a ser excluído. Não deve ser nulo.
     */
    public void excluir(Integer id) {
        psicologoRepository.deleteById(id);
    }

    /**
     * Obtém a quantidade total de psicólogos.
     * 
     * <p>Este método retorna o número total de psicólogos armazenados no repositório.</p>
     * 
     * @return A quantidade total de psicólogos.
     */
    public long obterQtde() {
        return psicologoRepository.count();
    }

    /**
     * Obtém um psicólogo pelo CRP.
     * 
     * <p>Este método recupera um psicólogo com base no CRP fornecido. Pode retornar null se nenhum psicólogo for encontrado.</p>
     * 
     * @param crp O CRP do psicólogo a ser recuperado. Não deve ser nulo ou vazio.
     * @return O {@link Psicologo} correspondente ao CRP fornecido, ou null se nenhum psicólogo for encontrado.
     */
    public Psicologo obterPorCrp(String crp) {
        return psicologoRepository.findByCrp(crp);
    }
}

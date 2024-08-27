package br.edu.infnet.appMatheusAvelino.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMatheusAvelino.model.domain.Atendimento;

/**
 * Interface para o repositório de {@link Atendimento}.
 * <p>
 * Esta interface é responsável pelas operações de persistência para a entidade {@link Atendimento}.
 * Ela estende {@link CrudRepository}, fornecendo métodos para realizar operações CRUD básicas,
 * além de métodos personalizados para consultas específicas.
 * </p>
 * 
 * @see CrudRepository
 * @see Atendimento
 */
@Repository
public interface AtendimentoRepository extends CrudRepository<Atendimento, Integer> {

    /**
     * Encontra atendimentos com base no status do atendimento.
     *
     * @param statusAtendimento o status do atendimento a ser encontrado
     * @return uma coleção de atendimentos com o status especificado
     */
    Collection<Atendimento> findBystatusAtendimento(boolean statusAtendimento);

    /**
     * Encontra atendimentos relacionados a um psicólogo específico.
     *
     * @param id o ID do psicólogo cujos atendimentos devem ser encontrados
     * @return uma coleção de atendimentos relacionados ao psicólogo com o ID especificado
     */
    Collection<Atendimento> findByPsicologoId(Integer id);

    /**
     * Encontra atendimentos relacionados a um paciente específico.
     *
     * @param id o ID do paciente cujos atendimentos devem ser encontrados
     * @return uma coleção de atendimentos relacionados ao paciente com o ID especificado
     */
    Collection<Atendimento> findByPacienteId(Integer id);

    /**
     * Encontra todos os atendimentos e os ordena de acordo com o parâmetro de ordenação fornecido.
     *
     * @param orderBy o critério de ordenação a ser aplicado
     * @return uma coleção de atendimentos ordenados conforme o critério especificado
     */
    Collection<Atendimento> findAll(Sort orderBy);
}

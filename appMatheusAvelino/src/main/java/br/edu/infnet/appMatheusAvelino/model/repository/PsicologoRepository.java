package br.edu.infnet.appMatheusAvelino.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMatheusAvelino.model.domain.Psicologo;

/**
 * Interface para o repositório de {@link Psicologo}.
 * <p>
 * Esta interface é responsável pelas operações de persistência para a entidade {@link Psicologo}.
 * Ela estende {@link CrudRepository}, fornecendo métodos para realizar operações CRUD básicas,
 * além de métodos personalizados para consultas específicas.
 * </p>
 * 
 * @see CrudRepository
 * @see Psicologo
 */
@Repository
public interface PsicologoRepository extends CrudRepository<Psicologo, Integer> {

    /**
     * Encontra um psicólogo pelo CRP (Cadastro de Registro Profissional).
     *
     * @param crp o CRP do psicólogo a ser encontrado
     * @return o psicólogo com o CRP especificado, ou {@code null} se nenhum psicólogo for encontrado
     */
    Psicologo findByCrp(String crp);

    /**
     * Encontra todos os psicólogos e os ordena de acordo com o parâmetro de ordenação fornecido.
     *
     * @param orderby o critério de ordenação a ser aplicado
     * @return uma coleção de psicólogos ordenados conforme o critério especificado
     */
    Collection<Psicologo> findAll(Sort orderby);
}

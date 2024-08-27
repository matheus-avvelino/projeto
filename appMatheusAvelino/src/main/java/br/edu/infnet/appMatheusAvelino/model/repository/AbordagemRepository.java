package br.edu.infnet.appMatheusAvelino.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMatheusAvelino.model.domain.Abordagem;

/**
 * Interface para o repositório de {@link Abordagem}.
 * <p>
 * Esta interface é responsável pelas operações de persistência para a entidade {@link Abordagem}.
 * Ela estende {@link CrudRepository}, fornecendo métodos para realizar operações CRUD básicas,
 * além de métodos personalizados para consultas específicas.
 * </p>
 * 
 * @see CrudRepository
 * @see Abordagem
 */
@Repository
public interface AbordagemRepository extends CrudRepository<Abordagem, Integer> {

    /**
     * Encontra todas as abordagens e as ordena de acordo com o parâmetro de ordenação fornecido.
     *
     * @param orderBy o critério de ordenação a ser aplicado
     * @return uma coleção de abordagens ordenadas conforme o critério especificado
     */
    Collection<Abordagem> findAll(Sort orderBy);
}

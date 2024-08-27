package br.edu.infnet.appMatheusAvelino.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMatheusAvelino.model.domain.Usuario;

/**
 * Interface para o repositório de {@link Usuario}.
 * <p>
 * Esta interface é responsável pelas operações de persistência para a entidade {@link Usuario}.
 * Ela estende {@link CrudRepository}, fornecendo métodos para realizar operações CRUD básicas,
 * além de métodos personalizados para consultas específicas.
 * </p>
 * 
 * @see CrudRepository
 * @see Usuario
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    /**
     * Encontra todos os usuários com a idade especificada.
     *
     * @param idade a idade dos usuários a serem encontrados
     * @return uma coleção de usuários com a idade especificada
     */
    Collection<Usuario> findByIdade(int idade);

    /**
     * Encontra todos os usuários e os ordena de acordo com o parâmetro de ordenação fornecido.
     *
     * @param orderby o critério de ordenação a ser aplicado
     * @return uma coleção de usuários ordenados conforme o critério especificado
     */
    Collection<Usuario> findAll(Sort orderby);
}

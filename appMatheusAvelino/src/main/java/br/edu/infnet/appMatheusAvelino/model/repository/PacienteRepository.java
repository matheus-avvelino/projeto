package br.edu.infnet.appMatheusAvelino.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appMatheusAvelino.model.domain.Paciente;

/**
 * Interface para o repositório de {@link Paciente}.
 * <p>
 * Esta interface é responsável pelas operações de persistência para a entidade {@link Paciente}.
 * Ela estende {@link CrudRepository}, fornecendo métodos para realizar operações CRUD básicas,
 * além de métodos personalizados para consultas específicas.
 * </p>
 * 
 * @see CrudRepository
 * @see Paciente
 */
@Repository
public interface PacienteRepository extends CrudRepository<Paciente, Integer> {

    /**
     * Encontra um paciente pelo CPF.
     *
     * @param cpf o CPF do paciente a ser encontrado
     * @return o paciente com o CPF especificado, ou {@code null} se nenhum paciente for encontrado
     */
    Paciente findByCpf(String cpf);

    /**
     * Encontra todos os pacientes e os ordena de acordo com o parâmetro de ordenação fornecido.
     *
     * @param orderby o critério de ordenação a ser aplicado
     * @return uma coleção de pacientes ordenados conforme o critério especificado
     */
    Collection<Paciente> findAll(Sort orderby);
}

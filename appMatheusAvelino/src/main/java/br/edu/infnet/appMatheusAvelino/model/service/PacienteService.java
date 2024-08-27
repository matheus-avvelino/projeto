package br.edu.infnet.appMatheusAvelino.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMatheusAvelino.model.domain.Paciente;
import br.edu.infnet.appMatheusAvelino.model.repository.PacienteRepository;

/**
 * Serviço responsável pela gestão de pacientes no sistema.
 * 
 * <p>Este serviço fornece métodos para realizar operações de persistência e recuperação de dados
 * relacionados a pacientes, utilizando o {@link PacienteRepository} para interagir com o banco de dados.</p>
 * 
 * @see Paciente
 * @see PacienteRepository
 */
@Service
public class PacienteService {

    /**
     * Repositório usado para operações de persistência e recuperação de dados de pacientes.
     */
    @Autowired
    private PacienteRepository pacienteRepository;

    /**
     * Inclui um novo paciente na base de dados.
     * 
     * <p>Este método salva o paciente fornecido no repositório. Caso ocorra uma exceção durante a operação,
     * a mensagem de erro é exibida no console.</p>
     * 
     * @param paciente O paciente a ser incluído. Não deve ser nulo.
     */
    public void incluir(Paciente paciente) {
        try {
            pacienteRepository.save(paciente);
        } catch (Exception e) {
            System.err.println("[ERROR] " + e.getMessage());
        }
    }

    /**
     * Obtém a lista completa de pacientes.
     * 
     * <p>Este método recupera todos os pacientes armazenados no repositório.</p>
     * 
     * @return Um {@link Iterable} contendo todos os pacientes.
     */
    public Iterable<Paciente> obterLista() {
        return pacienteRepository.findAll();
    }
    
    /**
     * Obtém a lista de pacientes ordenada por um atributo específico.
     * 
     * <p>Este método recupera todos os pacientes e os ordena de acordo com o atributo especificado.</p>
     * 
     * @param orderBy O nome do atributo pelo qual os pacientes devem ser ordenados. Não deve ser nulo ou vazio.
     * @return Um {@link Iterable} contendo todos os pacientes ordenados conforme o atributo fornecido.
     */
    public Iterable<Paciente> obterLista(String orderBy) {
        return pacienteRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
    }

    /**
     * Obtém um paciente pelo ID.
     * 
     * <p>Este método recupera um paciente com base no ID fornecido. Se o paciente não for encontrado, retorna null.</p>
     * 
     * @param id O ID do paciente a ser recuperado. Não deve ser nulo.
     * @return O {@link Paciente} correspondente ao ID fornecido, ou null se nenhum paciente for encontrado.
     */
    public Paciente obterPorId(Integer id) {
        return pacienteRepository.findById(id).orElse(null);
    }

    /**
     * Exclui um paciente pelo ID.
     * 
     * <p>Este método remove o paciente com o ID especificado do repositório.</p>
     * 
     * @param id O ID do paciente a ser excluído. Não deve ser nulo.
     */
    public void excluir(Integer id) {
        pacienteRepository.deleteById(id);
    }

    /**
     * Obtém a quantidade total de pacientes.
     * 
     * <p>Este método retorna o número total de pacientes armazenados no repositório.</p>
     * 
     * @return A quantidade total de pacientes.
     */
    public long obterQtde() {
        return pacienteRepository.count();
    }

    /**
     * Obtém um paciente pelo CPF.
     * 
     * <p>Este método recupera um paciente com base no CPF fornecido. Pode retornar null se nenhum paciente for encontrado.</p>
     * 
     * @param cpf O CPF do paciente a ser recuperado. Não deve ser nulo ou vazio.
     * @return O {@link Paciente} correspondente ao CPF fornecido, ou null se nenhum paciente for encontrado.
     */
    public Paciente obterPorCpf(String cpf) {
        return pacienteRepository.findByCpf(cpf);
    }
}

package br.edu.infnet.appMatheusAvelino.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMatheusAvelino.model.domain.Abordagem;
import br.edu.infnet.appMatheusAvelino.model.repository.AbordagemRepository;

/**
 * Serviço responsável pela gestão de abordagens no sistema.
 * 
 * <p>Este serviço fornece métodos para realizar operações de persistência e recuperação de dados
 * relacionados a abordagens, utilizando o {@link AbordagemRepository} para interagir com o banco de dados.</p>
 * 
 * @see Abordagem
 * @see AbordagemRepository
 */
@Service
public class AbordagemService {

	/**
	 * Repositório usado para operações de persistência e recuperação de dados de abordagens.
	 */
	@Autowired
	private AbordagemRepository abordagemRepository;

	/**
	 * Inclui uma nova abordagem na base de dados.
	 * 
	 * <p>Este método salva a abordagem fornecida no repositório. Se ocorrer algum erro, uma mensagem de erro é exibida.</p>
	 * 
	 * @param abordagem A abordagem a ser incluída. Não deve ser nula.
	 */
	public void incluir(Abordagem abordagem) {
		try {
			abordagemRepository.save(abordagem);
		} catch (Exception e) {
			System.err.println("[ERROR] " + e.getMessage());
		}
	}

	/**
	 * Obtém a lista completa de abordagens.
	 * 
	 * <p>Este método recupera todas as abordagens armazenadas no repositório.</p>
	 * 
	 * @return Um {@link Iterable} contendo todas as abordagens.
	 */
	public Iterable<Abordagem> obterLista() {
		return abordagemRepository.findAll();
	}
	
	/**
	 * Obtém a lista de abordagens ordenada por um atributo específico.
	 * 
	 * <p>Este método recupera todas as abordagens e as ordena de acordo com o atributo especificado.</p>
	 * 
	 * @param orderBy O nome do atributo pelo qual as abordagens devem ser ordenadas. Não deve ser nulo ou vazio.
	 * @return Um {@link Iterable} contendo todas as abordagens ordenadas conforme o atributo fornecido.
	 */
	public Iterable<Abordagem> obterLista(String orderBy) {
		return abordagemRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
	}

	/**
	 * Obtém uma abordagem pelo ID.
	 * 
	 * <p>Este método recupera uma abordagem específica com base no ID fornecido. Se a abordagem não for encontrada,
	 * o método retorna {@code null}.</p>
	 * 
	 * @param id O ID da abordagem a ser recuperada. Deve ser um valor válido.
	 * @return A abordagem correspondente ao ID fornecido, ou {@code null} se não encontrada.
	 */
	public Abordagem obterPorId(Integer id) {
		return abordagemRepository.findById(id).orElse(null);
	}

	/**
	 * Exclui uma abordagem pelo ID.
	 * 
	 * <p>Este método remove a abordagem correspondente ao ID fornecido do repositório.</p>
	 * 
	 * @param id O ID da abordagem a ser excluída. Deve ser um valor válido.
	 */
	public void excluir(Integer id) {
		abordagemRepository.deleteById(id);
	}

	/**
	 * Obtém a quantidade total de abordagens.
	 * 
	 * <p>Este método retorna o número total de abordagens armazenadas no repositório.</p>
	 * 
	 * @return A quantidade total de abordagens.
	 */
	public long obterQtde() {
		return abordagemRepository.count();
	}
}

package br.edu.infnet.appMatheusAvelino.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infnet.appMatheusAvelino.model.domain.Usuario;
import br.edu.infnet.appMatheusAvelino.model.repository.UsuarioRepository;

/**
 * Serviço responsável pela gestão de usuários no sistema.
 * 
 * <p>Este serviço fornece métodos para realizar operações de persistência e recuperação de dados
 * relacionados a usuários, utilizando o {@link UsuarioRepository} para interagir com o banco de dados.</p>
 * 
 * @see Usuario
 * @see UsuarioRepository
 */
@Service
public class UsuarioService {
	
	/**
	 * Repositório usado para operações de persistência e recuperação de dados de usuários.
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 * Obtém a lista completa de usuários.
	 * 
	 * <p>Este método recupera todos os usuários armazenados no repositório.</p>
	 * 
	 * @return Um {@link Iterable} contendo todos os usuários.
	 */
	public Iterable<Usuario> obterLista() {
		return usuarioRepository.findAll();
	}
	
	/**
	 * Obtém a lista de usuários ordenada por um atributo específico.
	 * 
	 * <p>Este método recupera todos os usuários e os ordena de acordo com o atributo especificado.</p>
	 * 
	 * @param orderBy O nome do atributo pelo qual os usuários devem ser ordenados. Não deve ser nulo ou vazio.
	 * @return Um {@link Iterable} contendo todos os usuários ordenados conforme o atributo fornecido.
	 */
	public Iterable<Usuario> obterLista(String orderBy) {
		return usuarioRepository.findAll(Sort.by(Sort.Direction.ASC, orderBy));
	}

	/**
	 * Obtém a quantidade total de usuários.
	 * 
	 * <p>Este método retorna o número total de usuários armazenados no repositório.</p>
	 * 
	 * @return A quantidade total de usuários.
	 */
	public long obterQtde() {
		return usuarioRepository.count();
	}
	
	/**
	 * Obtém usuários com uma idade específica.
	 * 
	 * <p>Este método recupera todos os usuários com a idade fornecida.</p>
	 * 
	 * @param idade A idade dos usuários a serem recuperados. Deve ser um valor válido.
	 * @return Uma {@link Collection} contendo todos os usuários com a idade especificada.
	 */
	public Collection<Usuario> obterPorIdade(int idade){
		return usuarioRepository.findByIdade(idade);
	}
}

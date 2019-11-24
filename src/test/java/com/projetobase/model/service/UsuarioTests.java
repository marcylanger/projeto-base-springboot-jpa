package com.projetobase.model.service;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.jdbc.Sql;

import com.projetobase.model.entity.RoleEnum;
import com.projetobase.model.entity.Usuario;
import com.projetobase.model.repository.UsuarioRepository;


public class UsuarioTests extends AbstractIntegrationTests
{
	/*-------------------------------------------------------------------
	 *				 		     ATTRIBUTES
	 *-------------------------------------------------------------------*/

	/**
	 * Password encoder
	 */
	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 *
	 */
	@Autowired
	private UsuarioRepository usuarioRepository;

	/**
	 *
	 */
	@Autowired
	private UsuarioService usuarioService;
	
	/*-------------------------------------------------------------------
	 *				 		      TESTS
	 *-------------------------------------------------------------------*/


	//======== CADASTRAR USUÁRIO =============

	/**
	 *
	 */
	@Test
	@WithUserDetails("marcieli.langer@mailinator.com")
	@Sql( {		    
	      "/dataset/truncate.sql",
				"/dataset/usuarios.sql"
		})
	public void cadastrarUsuarioMustPass()
	{
		Usuario usuario = new Usuario();
		usuario.setNome("Marcieli");
		usuario.setEmail( "marcieli@mailinator.com" );
		usuario.setPerfil( RoleEnum.ADMINISTRATOR );
		this.usuarioService.cadastrarUsuario(usuario);
		Assert.assertNotNull( usuario );
		Assert.assertNotNull( usuario.getId() );

	}
	
	
	// falta fazer os testes com campos obrigatórios null
	
	//======== ATIVAR USUÁRIO =============
	
	/**
	 * Teste para ativar um usuário do sistema com sucesso
	 */
	@Test
	@WithUserDetails("marcieli.langer@mailinator.com")
	@Sql( {		    
      "/dataset/truncate.sql",
			"/dataset/usuarios.sql"
	})
	public void ativarUsuarioMustPass(){
		this.usuarioService.ativarUsuario("123456", "123456", "f786c907-032e-451b-ac93-8508dec75a3d");

		Usuario usuarioAtivo = this.usuarioRepository.findByEmailIgnoreCase( "marcieli.langer@mailinator.com" );
		Assert.assertEquals( true, usuarioAtivo.getAtivo() );
	}
	
	//Falta fazer testes com token inválido, token null, token vencido, senha null, senhas diferentes
	
	
	//======== ESQUECI MINHA SENHA =============

	

	@Test
	@Sql( {		    
      "/dataset/truncate.sql",
			"/dataset/usuarios.sql"
	})
	public void enviarEmailRecuperarSenhaUsuarioMustPass(){
		this.usuarioService.enviarEmailRecuperarSenhaUsuario("marcieli.langer@mailinator.com");
		Usuario usuario = this.usuarioRepository.findByEmailIgnoreCase( "marcieli.langer@mailinator.com" );
		
		Assert.assertNotNull( usuario);
		Assert.assertNotNull( usuario.getPasswordResetToken());
		Assert.assertNotNull( usuario.getPasswordResetTokenExpiration());
	}
	
	//Faltou testes com email que não existe e sem passar email
	
	
	//======== REDEFINIR MINHA SENHA =============

	/**
	 * Serviço que redefinir senha de um usuário com sucesso
	 * 
	*/
	@Test()
	@Sql( {		    
	      "/dataset/truncate.sql",
				"/dataset/usuarios.sql"
		})
	public void redefinirSenhaMustPass(){
		this.usuarioService.redefinirSenha("123456","123456", "f786c907-032e-451b-ac93-8508dec75a3d");
	}

	//Falta testes sem passar token, com token inválido, com token vencido, com senhas que não conferem, com senha null


	//======== PEGAR USUÁRIO AUTENTICADO =============

	
	@Test
	@WithUserDetails("marcieli.langer@mailinator.com")
	@Sql( {		    
	      "/dataset/truncate.sql",
				"/dataset/usuarios.sql"
		})
	public void pegarUsuarioAutenticadoTestMustPass() {
		Usuario usuario = this.usuarioService.getAuthenticatedUser();
		Assert.assertNotNull( usuario );
		Assert.assertNotNull( usuario.getId() );
		
	}
	
	
	//======== ALTERAR MINHA CONTA =============

}
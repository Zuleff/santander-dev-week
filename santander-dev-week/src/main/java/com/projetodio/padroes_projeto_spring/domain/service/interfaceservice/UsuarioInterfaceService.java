package com.projetodio.padroes_projeto_spring.domain.service.interfaceservice;

import java.util.List;
import static java.util.Optional.ofNullable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetodio.padroes_projeto_spring.domain.model.Usuario;
import com.projetodio.padroes_projeto_spring.domain.repository.UsuarioRepository;
import com.projetodio.padroes_projeto_spring.domain.service.UsuarioService;
import com.projetodio.padroes_projeto_spring.domain.service.excecoes.ExcecaoNegocios;
import com.projetodio.padroes_projeto_spring.domain.service.excecoes.NaoEncontradoExcecao;

@Service
public class UsuarioInterfaceService implements UsuarioService {

    /**
     * ID de usuário utilizado na Santander Dev Week 2023. Por isso, vamos criar
     * algumas regras para mantê-lo integro.
     */
    private static final Long UNCHANGEABLE_USER_ID = 1L;

    private final UsuarioRepository usuarioRepository;

    public UsuarioInterfaceService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return this.usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return this.usuarioRepository.findById(id).orElseThrow(NaoEncontradoExcecao::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario create(Usuario userToCreate) {
        ofNullable(userToCreate).orElseThrow(() -> new ExcecaoNegocios("Usuário nulo"));
        ofNullable(userToCreate.getConta()).orElseThrow(() -> new ExcecaoNegocios("O valor da conta está nulo"));
        ofNullable(userToCreate.getCartao()).orElseThrow(() -> new ExcecaoNegocios("O valor do cartão está nulo"));

        this.validateChangeableId((Long) userToCreate.getId(), "created");
        if (usuarioRepository.existsByContaNumero(userToCreate.getConta().getNumero())) {
            throw new ExcecaoNegocios("Já existe uma conta com esse número.");
        }
        if (usuarioRepository.existsByCartaoNumero(userToCreate.getCartao().getNumero())) {
            throw new ExcecaoNegocios("Já existe um cartão com esse número.");
        }
        return this.usuarioRepository.save(userToCreate);
    }

    @Override
    @Transactional
    public Usuario update(Long id, Usuario userToUpdate) {
        this.validateChangeableId(id, "Atualizado");
        Usuario dbUser = this.findById(id);
        if (!dbUser.getId().equals(userToUpdate.getId())) {
            throw new ExcecaoNegocios("Não foi possível atualiar o ID do usuário");
        }

        dbUser.setNome(userToUpdate.getNome());
        dbUser.setConta(userToUpdate.getConta());
        dbUser.setCartao(userToUpdate.getCartao());
        dbUser.setServicos(userToUpdate.getServicos());
        dbUser.setNoticias(userToUpdate.getNoticias());

        return this.usuarioRepository.save(dbUser);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        this.validateChangeableId(id, "deletado");
        Usuario dbUser = this.findById(id);
        this.usuarioRepository.delete(dbUser);
    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_USER_ID.equals(id)) {
            throw new ExcecaoNegocios("User with ID %d can not be %s.".formatted(UNCHANGEABLE_USER_ID, operation));
        }
    }

}

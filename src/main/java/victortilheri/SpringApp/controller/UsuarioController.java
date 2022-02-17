package victortilheri.SpringApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import victortilheri.SpringApp.model.UsuarioModel;
import victortilheri.SpringApp.repository.UsuarioRespository;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    UsuarioRespository usuarioRepository;

    @GetMapping(path = "api/usuarios")
    List<UsuarioModel> listarTodos () {
        List<UsuarioModel> result = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuario -> result.add(usuario));
        return result;
    }

    @GetMapping(path = "api/usuarios/{codigo}")
    ResponseEntity consultarPorCodigo(@PathVariable("codigo") Integer codigo) {
        return usuarioRepository.findById(codigo)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "api/usuarios")
    UsuarioModel salvar (@RequestBody UsuarioModel usuario) {
        return usuarioRepository.save(usuario);
    }

    @PutMapping(path = "api/usuarios/{codigo}")
    UsuarioModel atualizarUsuarioPeloId (@PathVariable("codigo") Integer codigo,@RequestBody UsuarioModel novoUsuario) {
        UsuarioModel usuario = usuarioRepository.findById(codigo).get();
        usuario.setNome(novoUsuario.getNome());
        usuario.setLogin(novoUsuario.getLogin());
        usuario.setSenha(novoUsuario.getSenha());
        usuario.setCidade(novoUsuario.getCidade());
        usuarioRepository.save(usuario);
        return usuario;
    }

    @DeleteMapping(path = "api/usuarios/{codigo}")
    String removerPorCodigo(@PathVariable("codigo") Integer codigo) {
        usuarioRepository.deleteById(codigo);
        return "Usuário deletado!";
    }
}

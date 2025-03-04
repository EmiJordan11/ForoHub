package alura.foro_hub.controller;

import alura.foro_hub.dto.auth.TokenDTO;
import alura.foro_hub.dto.usuario.LoginUsuarioDTO;
import alura.foro_hub.dto.usuario.SingUpUsuarioDTO;
import alura.foro_hub.entities.Usuario;
import alura.foro_hub.repository.UsuarioRepository;
import alura.foro_hub.service.auth.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity autenticarUsuario(@RequestBody @Valid LoginUsuarioDTO datos){
        Authentication authToken = new UsernamePasswordAuthenticationToken(datos.email(), datos.contrasena());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var jwtToken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(jwtToken));
    }

    @PostMapping("/singup")
    public ResponseEntity registrarUsuario(@RequestBody @Valid SingUpUsuarioDTO datos){
        Usuario usuario = new Usuario(datos);
        usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));

        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente");
    }

}

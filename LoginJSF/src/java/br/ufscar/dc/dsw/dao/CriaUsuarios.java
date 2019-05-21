package br.ufscar.dc.dsw.dao;

import br.ufscar.dc.dsw.pojo.Papel;
import br.ufscar.dc.dsw.pojo.Usuario;
import br.ufscar.dc.dsw.pojo.Cliente;
import br.ufscar.dc.dsw.pojo.Locadora;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriaUsuarios {

    public static void main(String[] args) throws ClassNotFoundException {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        PapelDAO papelDAO = new PapelDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        LocadoraDAO locadoraDAO = new LocadoraDAO();

        // Criando Usuario admin com papel ROLE_ADMIN
     
        Usuario u1 = new Usuario();
        u1.setEmail("admin@admin");
        u1.setPassword(encoder.encode("admin"));
        u1.setAtivo(true);
        usuarioDAO.save(u1);

        Papel p1 = new Papel();
        p1.setNome("ROLE_ADMIN");
        papelDAO.save(p1);

        u1.getPapel().add(p1);
        usuarioDAO.update(u1);
        
        // Criando Usuario cliente com papel ROLE_CLIENTE
        
        Cliente c1 = new Cliente();
        c1.setEmail("cliente@cliente");
        c1.setPassword(encoder.encode("cliente"));
        c1.setBirthDate("21/02/2000");
        c1.setCPF("420450123");
        c1.setGender("M");
        c1.setPhone("23872378");
        clienteDAO.save(c1);
        
        Papel p3 = new Papel();
        p3.setNome("ROLE_CLIENTE");
        papelDAO.save(p3);
        
        Usuario u3 = new Usuario();
        u3.setEmail(c1.getEmail());
        u3.setPassword(c1.getPassword());
        u3.setAtivo(true);
        usuarioDAO.save(u3);
        
        u3.getPapel().add(p3);
        usuarioDAO.update(u3);
        
        // Criando Usuario locadora com papel ROLE_LOCADORA
        
        Locadora l1 = new Locadora();
        l1.setEmail("locadora@locadora");
        l1.setPassword(encoder.encode("locadora"));
        l1.setCNPJ("420450123");
        l1.setName("Locadora 1");
        l1.setCity("São Carlos");
        locadoraDAO.save(l1);
        
        Papel p2 = new Papel();
        p2.setNome("ROLE_LOCADORA");
        papelDAO.save(p3);
        
        Usuario u2 = new Usuario();
        u2.setEmail(l1.getEmail());
        u2.setPassword(l1.getPassword());
        u2.setAtivo(true);
        usuarioDAO.save(u2);
        
        u2.getPapel().add(p2);
        usuarioDAO.update(u2);
    }
}

package com.cocobolo.t4pascual.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cocobolo.t4pascual.model.dao.IUsuarioDAO;
import com.cocobolo.t4pascual.model.entidad.Rol;
import com.cocobolo.t4pascual.model.entidad.Usuario;

@Service("UserService")
public class UserService implements UserDetailsService {

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByUsername(username);
        List<GrantedAuthority> listaRoles = new ArrayList<>();
        for(Rol item : usuario.getRoles()){
            listaRoles.add(new SimpleGrantedAuthority(item.getAuthority()));
        }
        return new User(usuario.getUsername(), usuario.getPassword(),listaRoles);
    }
    
}

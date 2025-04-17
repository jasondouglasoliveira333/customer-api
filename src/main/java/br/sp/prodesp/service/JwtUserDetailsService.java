package br.sp.prodesp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.sp.prodesp.dto.POCUser;
import br.sp.prodesp.entity.User;
import br.sp.prodesp.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User u = userRepository.findByName(username);
		if (u != null) {
			return new POCUser(u.getId(), u.getName(), u.getPassword(), new ArrayList<>());
		}else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
package br.sp.prodesp.service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.sp.prodesp.dto.PageResponse;
import br.sp.prodesp.dto.UserDTO;
import br.sp.prodesp.entity.User;
import br.sp.prodesp.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public PageResponse<UserDTO> findAll(PageRequest pg) {
		PageResponse<UserDTO> prUser = new PageResponse<>();
		Page<User> pUser = userRepository.findAll(pg);
		prUser.setContent(pUser.getContent().stream().map(u -> modelMapper.map(u, UserDTO.class)).collect(Collectors.toList()));
		prUser.setTotalPages(pUser.getTotalPages());
		return prUser;
	}
	
	public UserDTO getOne(Integer id) {
		User u = userRepository.getOne(id);
		UserDTO uDTO = modelMapper.map(u, UserDTO.class);
		return uDTO;
	}

	@Transactional
	public void save(UserDTO uDTO) {
		User u = modelMapper.map(uDTO, User.class);
		if (u.getPassword() != null) {//updating the password or insert a new user
			u.setPassword(bCryptPasswordEncoder.encode(u.getPassword()));
			if (u.getId() == null) {
				u.setCreationDate(LocalDateTime.now());
			}
			userRepository.save(u);
		}else {
			userRepository.updateName(u.getName(), u.getId());
		}
	}
	
	public void deleteById(Integer id) {
		userRepository.deleteById(id);
	}

}

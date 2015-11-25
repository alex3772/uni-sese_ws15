package org.scrum1.sese.service.hibernate;

import org.scrum1.sese.repository.RoleRepository;
import org.scrum1.sese.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

	private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired private RoleRepository roleRepository;


}

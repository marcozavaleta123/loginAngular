package com.pe.Service.Impl;

import org.springframework.stereotype.Service;

import com.pe.Service.LoginService;
import com.pe.Util.Constante;

@Service
public class LoginServiceImpl implements LoginService{

	@Override
	public String validarLogin(String user, String clave) {
		if(user.equals("admin") && clave.equals("admin")){
			return Constante.msjOK;
		}
		return Constante.msjError;
	}

}

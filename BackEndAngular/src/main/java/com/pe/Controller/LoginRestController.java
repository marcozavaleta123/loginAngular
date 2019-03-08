package com.pe.Controller;

import java.io.IOException;
import java.util.Date;

import javax.xml.ws.Response;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.pe.Service.LoginService;
import com.pe.Util.Constante;
import com.pe.Util.RestResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
public class LoginRestController {
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "/iniciarSesion", method = RequestMethod.GET)
	public RestResponse iniciarSesion(@RequestParam(value="usuario") String usuario, @RequestParam(value="clave") String clave)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("hola mundo");
		
		RestResponse r = new RestResponse();
		
		if(loginService.validarLogin(usuario, clave).equals(Constante.msjOK)){
			String jwt = generarJwtToken();
			
			r.setJwt(jwt);
		}else
		r.setJwt("error");
		
		return r;
		
	}
	
	public String generarJwtToken() {
        return Jwts.builder()
		                .setSubject(("ADMINISTRADOR DEL SISTEMA"))
		                .setIssuedAt(new Date())
		                .setExpiration(new Date((new Date()).getTime() + 900000))
		                .signWith(SignatureAlgorithm.HS512, Constante.clave)
		                .claim("email", "abc@gmail.com")
		                .claim("nombres", "Luis Flores Perez")
		                .claim("cargo", "ADMINISTRADOR DEL SISTEMA")
		                .claim("url", "home")
		                .compact();
    }

}

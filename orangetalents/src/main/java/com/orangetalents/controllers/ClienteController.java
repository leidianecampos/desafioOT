package com.orangetalents.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.orangetalents.models.Cliente;
import com.orangetalents.repository.ClienteRepository;

@Controller
public class ClienteController {

	@Autowired
	private ClienteRepository er;
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.GET)
	public String form() {
		return "cliente/formCliente";
	}
	
	@RequestMapping(value="/cadastrarCliente", method=RequestMethod.POST)
	public String form(@Valid Cliente cliente, BindingResult result, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastrarCliente";
		}
		
		er.save(cliente);
		attributes.addFlashAttribute("mensagem", "Cliente cadastrado com sucesso!");
		return "redirect:/cadastrarCliente";
	}
	
	@RequestMapping ("/clientes")
	public ModelAndView listaClientes() {
		ModelAndView mv = new ModelAndView("index");
		Iterable <Cliente> clientes = er.findAll();
		mv.addObject("clientes", clientes);
		return mv;
	}

}

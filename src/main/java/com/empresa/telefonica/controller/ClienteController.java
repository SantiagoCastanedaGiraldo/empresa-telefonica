package com.empresa.telefonica.controller;

import com.empresa.telefonica.model.Cliente;
import com.empresa.telefonica.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    // Mostrar todos los clientes
    @GetMapping
    public String listarClientes(Model model) {

        model.addAttribute("clientes",
                clienteRepository.findAll());

        return "clientes";
    }

    // Mostrar formulario para nuevo cliente
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {

        model.addAttribute("cliente", new Cliente());

        return "formulario-cliente";
    }

    // Guardar cliente
    @PostMapping("/guardar")
    public String guardarCliente(@ModelAttribute Cliente cliente) {

        clienteRepository.save(cliente);

        return "redirect:/clientes";
    }

    // Editar cliente
    @GetMapping("/editar/{id}")
    public String editarCliente(@PathVariable int id,
                                Model model) {

        Cliente cliente =
                clienteRepository.findById(id).orElse(null);

        model.addAttribute("cliente", cliente);

        return "formulario-cliente";
    }

    // Eliminar cliente
    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable int id) {

        clienteRepository.deleteById(id);

        return "redirect:/clientes";
    }
}
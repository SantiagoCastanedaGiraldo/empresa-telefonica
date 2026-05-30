package com.empresa.telefonica.controller;

// Importamos la entidad Plan
import com.empresa.telefonica.model.Plan;

// Importamos el repositorio para acceder a la base de datos
import com.empresa.telefonica.repository.PlanRepository;

// Importaciones necesarias de Spring
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlanController {

    // Creamos una variable para utilizar el repositorio
    private final PlanRepository planRepository;

    // Constructor que recibe automáticamente el repositorio
    public PlanController(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    // Mostrar todos los planes registrados
    @GetMapping("/planes")
    public String listarPlanes(Model model) {

        // Enviamos la lista de planes a la vista
        model.addAttribute("planes", planRepository.findAll());

        return "planes";
    }
    // Muestra el formulario para crear un nuevo plan
    @GetMapping("/planes/nuevo")
    public String mostrarFormularioNuevo(Model model) {

        // Enviamos un objeto Plan vacío al formulario
        model.addAttribute("plan", new Plan());

        return "formulario-plan";
    }
    @PostMapping("/planes/guardar")
    public String guardarPlan(@ModelAttribute Plan plan) {

        planRepository.save(plan);

        return "redirect:/planes";
    }
    // Elimina un plan por medio de su id
    @GetMapping("/planes/eliminar/{id}")
    public String eliminarPlan(@PathVariable int id) {

        // Eliminamos el plan de la base de datos
        planRepository.deleteById(id);

        // Volvemos al listado de planes
        return "redirect:/planes";
    }
    // Muestra el formulario con los datos del plan que se desea editar
    @GetMapping("/planes/editar/{id}")
    public String editarPlan(@PathVariable int id, Model model) {

        // Buscamos el plan por su id
        Plan plan = planRepository.findById(id).orElse(null);

        // Enviamos el plan encontrado al formulario
        model.addAttribute("plan", plan);

        return "formulario-plan";
    }

}
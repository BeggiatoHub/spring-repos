package com.spring.demo;

//import com.spring.demo.Spesa;
//import com.spring.demo.SpesaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpesaWebController {

    private final SpesaRepository spesaRepo;

    public SpesaWebController(SpesaRepository spesaRepo) {
        this.spesaRepo = spesaRepo;
    }

    @GetMapping("/")
    public String elencoSpese(@RequestParam(required = false) Categoria categoria, Model model) {
    List<Spesa> spese;

    if (categoria != null) {
        spese = spesaRepo.findByCategoria(categoria);
    } else {
        spese = spesaRepo.findAll();
    }

    model.addAttribute("spese", spese);
    model.addAttribute("spesa", new Spesa());
    model.addAttribute("categorie", Arrays.asList(Categoria.values()));
    return "index";
    }

    @GetMapping("/add")
    public String addSpesa(Model model) {
        model.addAttribute("spese", spesaRepo.findAll());
        model.addAttribute("spesa", new Spesa());
        model.addAttribute("categorie", Arrays.asList(Categoria.values()));
        return "add";
    }
    
    @PostMapping("/aggiungi")
    public String aggiungiSpesa(@ModelAttribute Spesa spesa) {
        spesaRepo.save(spesa);
        return "redirect:/";
    }

    @GetMapping("/modifica/{id}")
    public String modificaSpesa(@PathVariable Long id, Model model) {
        Spesa spesa = spesaRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("ID non valido: " + id));
        model.addAttribute("spesa", spesa);
        model.addAttribute("categorie", Arrays.asList(Categoria.values()));
        return "modifica"; // pagina HTML che mostreremo dopo
    }

    @PostMapping("/modifica")
    public String salvaModifica(@ModelAttribute Spesa spesa) {
        spesaRepo.save(spesa); // sovrascrive la spesa con lo stesso ID
        return "redirect:/";
    }

    @GetMapping("/elimina/{id}")
    public String eliminaSpesa(@PathVariable Long id) {
        spesaRepo.deleteById(id);
        return "redirect:/";
    }

}

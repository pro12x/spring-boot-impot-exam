package com.isi.web;

import com.isi.dao.DeclarantRepository;
import com.isi.entity.Declarant;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class DeclarantController
{
    private final DeclarantRepository declarantRepository;

    // Home Page
    @GetMapping("/")
    public String getHome() {
        return "index";
    }

    // Get
    @GetMapping("/declarant/list")
    public String get(Model model) {
        List<Declarant> listDeclarant = declarantRepository.findAll();
        model.addAttribute("declarant", new Declarant());
        model.addAttribute("listDeclarant", listDeclarant);
        return "declarants";
    }

    // Add
    @PostMapping("/declarant/add")
    public String add(Declarant declarant) {
        declarantRepository.save(declarant);
        return "redirect:/declarant/list";
    }

    // Update
    /*@GetMapping("/declaration/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Declarant declarant = declarantRepository.findById(id).orElse(null);
        if (declarant != null) {
            model.addAttribute("declarant", declarant);
            model.addAttribute("listDeclarant", declarantRepository.findAll());
            return "declarants";
        }
        return "redirect:/declarant/list";
    }*/

    // Delete
    @GetMapping("/declarant/delete/{id}")
    public String delete(@PathVariable Long id) {
        declarantRepository.deleteById(id);
        return "redirect:/declarant/list";
    }
}

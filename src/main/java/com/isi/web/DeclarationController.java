package com.isi.web;

import com.isi.dao.DeclarantRepository;
import com.isi.dao.DeclarationRepository;
import com.isi.entity.Declaration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DeclarationController
{
    private final DeclarantRepository declarantRepository;
    private final DeclarationRepository declarationRepository;

    @GetMapping("/declaration/list")
    public String get(Model model) {
        model.addAttribute("declarant", new Declaration());
        model.addAttribute("listDeclaration", declarationRepository.findAll());
        model.addAttribute("listDeclarant", declarantRepository.findAll());
        return "declarations";
    }

    @PostMapping("/declaration/add")
    public String add(Declaration declaration) {
        declarationRepository.save(declaration);
        return "redirect:/declaration/list";
    }

    @GetMapping("/declaration/delete/{id}")
    public String delete(@PathVariable Long id) {
        declarationRepository.deleteById(id);
        return "redirect:/declaration/list";
    }
}

package com.isi.web;

import com.isi.dao.DeclarationRepository;
import com.isi.dao.PaiementRepository;
import com.isi.entity.Declaration;
import com.isi.entity.Paiement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PaiementController
{
    private final PaiementRepository paiementRepository;
    private final DeclarationRepository declarationRepository;

    @GetMapping("/paiement/list")
    public String get(Model model) {
        model.addAttribute("declaration", new Paiement());
        model.addAttribute("listPaiement", paiementRepository.findAll());
        model.addAttribute("listDeclaration", declarationRepository.listNotPayed());
        //model.addAttribute("listDeclaration", declarationRepository.findAll());
        return "paiements";
    }

    @PostMapping("/paiement/add")
    public String add(Paiement paiement) {
        paiement.getDeclaration_id().setPayed(true);
        paiementRepository.save(paiement);
        return "redirect:/paiement/list";
    }

    @GetMapping("/paiement/delete/{id}")
    public String delete(@PathVariable Long id) {
        Paiement paiement = paiementRepository.findById(id).orElse(null);
        Declaration declaration = paiement.getDeclaration_id();
        declaration.setPayed(false);
        paiementRepository.deleteById(id);
        return "redirect:/paiement/list";
    }
}
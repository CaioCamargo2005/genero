package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Livro;
import application.repository.LivroRepository;
import application.repository.GeneroRepository;

@Controller
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private GeneroRepository generoRepository;


    @RequestMapping("/insert")
    public String insert() {
        ui.addAttribute("generos", generoRepository.findAll());
        return "/livros/insert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(
        @RequestParam("titulo") String titulo,
        @RequestParam("id_genero") long id_genero){

        Optional<Genero> genero = generoRepository.findById(id_genero);

        if(genero.isPresent()) {
            Livro livro = new Livro();
            livro.setTitulo(titulo);
            livro.setGenero(genero.get());

            livroRepository.save(livro);
           }

        }

        return "redirect:/livros/list";

    }

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("livros", livroRepository.findAll());

        return "/livros/list";
    }

package com.br.alexandredvlp.Blog.controller;

import com.br.alexandredvlp.Blog.model.Post;
import com.br.alexandredvlp.Blog.service.CodeblogService;
import org.hibernate.annotations.common.reflection.XMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CodeblogController {

    @Autowired
    private CodeblogService codeBlogService;

    /*
    @RequestMapping("/")
    public String index(){
        return "index";
    }*/

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPost() {
        ModelAndView modelAndView = new ModelAndView("posts");
        List<Post> postList = codeBlogService.findAll();
        modelAndView.addObject("posts", postList);
        return modelAndView;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView("postDetails");
        Post post = codeBlogService.findById(id);
        modelAndView.addObject("post", post);
        return modelAndView;
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm() {
        return "postForm";
    }

    // o valid valida que as validações da classe post estejao de acordo e resukt coleta o resultado da validação
    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            //se estiver um erro estoura a mensagem
            attributes.addFlashAttribute("mensagem", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        codeBlogService.save(post);
        return "redirect:/posts";
    }
}

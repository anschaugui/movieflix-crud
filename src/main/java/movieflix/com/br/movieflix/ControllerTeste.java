package movieflix.com.br.movieflix;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/docker")
public class ControllerTeste {

    @GetMapping
    public String teste(){
        return "Testando imagem docker";
    }

}

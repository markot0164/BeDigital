package it.unisa.darn.control.presentazionerisorse;

import it.unisa.darn.service.presentazionerisorse.VisualizzazioneRisorsaService;
import it.unisa.darn.storage.entity.Argomento;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/copertina")
public class CopertinaController {

  @Autowired
  private VisualizzazioneRisorsaService visualizzazioneRisorsaService;

  @GetMapping
  public void get(@RequestParam Long idArgomento, HttpServletResponse response) throws IOException {
    Optional<Argomento> optional = visualizzazioneRisorsaService.getArgomento(idArgomento);
    if (optional.isEmpty()) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }

    response.setContentType("image/jpeg");
    response.getOutputStream().write(optional.get().getCopertina());
  }
}
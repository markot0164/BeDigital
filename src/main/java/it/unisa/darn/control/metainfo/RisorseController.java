package it.unisa.darn.control.metainfo;

import it.unisa.darn.service.metainfo.VisualizzazioneRisorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/risorse")
public class RisorseController {

  @Autowired
  private VisualizzazioneRisorseService visualizzazioneRisorseService;

  @GetMapping
  public String get(Model model) {
    model.addAttribute("lezioni",
        visualizzazioneRisorseService.getAllLezioniSortedByLivelloKeywordTitolo());
    model.addAttribute("racconti",
        visualizzazioneRisorseService.getAllRaccontiSortedByLivelloKeywordTitolo());
    model.addAttribute("metainfo",
        visualizzazioneRisorseService.getAllMetaInfoSortedByLivelloKeyword());
    model.addAttribute("giochi",
        visualizzazioneRisorseService.getAllGiochiSortedByLivelloKeyword());
    model.addAttribute("domande",
        visualizzazioneRisorseService.getAllDomandeSortedByLivelloKeywordTesto());
    return "metainfo/risorse";
  }
}

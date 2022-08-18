package uz.pdp.springbootcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.springbootcrud.model.Employee;
import uz.pdp.springbootcrud.model.Position;
import uz.pdp.springbootcrud.service.PositionService;

import java.util.List;

@Controller
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping("/positions")
    public String listPositions(Model model){

        List<Position> allPositions = positionService.getAllPositions();
        model.addAttribute("positions",allPositions);

        return "positions-page";

    }

    @GetMapping("/positions/new")
    public String createPositionForm(Model model){

        model.addAttribute("positions", new Position());

        return "positions-form";

    }

    @PostMapping("/positions/save")
    public String savePosition(Position position){
        positionService.savePosition(position);
        return "redirect:/positions";
    }

    @GetMapping("/positions/edit/{id}")
    public String editPositions(@PathVariable("id") int id, Model model){
        Position position = positionService.getPosition(id);
        model.addAttribute("positions",position);


        return "positions-form";

    }

    @GetMapping("/positions/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id,Model model) {

        positionService.delete(id);

        return "redirect:/positions";

    }
}

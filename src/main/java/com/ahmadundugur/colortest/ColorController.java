package com.ahmadundugur.colortest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ColorController {
        private static List<Color> colors = new ArrayList<>();
        private static int counter = 0;
    @GetMapping("colorFun")
    public String colorFun(Model model){
        model.addAttribute("backgroundColor");
        if ( colors.size() == counter)
            counter = 0;
        model.addAttribute("backgroundColor", "background-color:" + colors.get(counter).getCssvalue());
        counter++;
        return "colorFunView";
    }
    @GetMapping("colorForm")
    public String colorForm(Model model){
        return "colorInputForm";
    }
    @PostMapping("choosingColors")
    public String saveColors(Color colorToSave) {
        colors.add(colorToSave);
        return "colorInputForm";
    }

}

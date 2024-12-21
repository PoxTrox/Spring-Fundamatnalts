package org.example.pathfinder.Web;

import org.example.pathfinder.Service.RouteService;
import org.example.pathfinder.Service.dto.RouteShortInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RouteController {


    private final RouteService routeService;



    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;

    }

    @GetMapping("/routes")
    public String routes( Model model) {
     //   RouteShortInfoDto routeShortInfoDto = routeService.gerRandomRoute();
        List<RouteShortInfoDto> routes = routeService.getAll();
        model.addAttribute("AllRoutes", routes);
        return "routes";
    }
}

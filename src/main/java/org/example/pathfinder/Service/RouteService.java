package org.example.pathfinder.Service;

import jakarta.transaction.Transactional;
import org.example.pathfinder.Repository.RouteRepository;
import org.example.pathfinder.Service.dto.RouteShortInfoDto;
import org.example.pathfinder.model.Picture;
import org.example.pathfinder.model.Route;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private Random random;
    private ModelMapper modelMapper;

    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
        this.modelMapper = new ModelMapper();

    }
    @Transactional
    public List<RouteShortInfoDto> getAll() {

      return   routeRepository.findAll().stream().map(this::mapToShortInfo).toList();
    }


    private RouteShortInfoDto mapToShortInfo(Route route) {
        RouteShortInfoDto dto = modelMapper.map(route, RouteShortInfoDto.class);
        Optional<Picture> first = route.getPictures().stream().findFirst();

        dto.setImageUrl(first.get().getUrl());
        return dto;
    }


    @Transactional
    public RouteShortInfoDto gerRandomRoute() {

        random = new Random();
        long count = routeRepository.count();
        long random = this.random.nextLong(count)+1;

        Optional<Route> byId = routeRepository.findById(random);
//        RouteShortInfoDto dto = modelMapper.map(byId.get(), RouteShortInfoDto.class);
//
//        Optional<Picture> first = byId.get().getPictures().stream().findFirst();
//        dto.setImageUrl(first.get().getUrl());
        return mapToShortInfo(byId.get());


    }
}

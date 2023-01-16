package com.petproject.shineexpert.loadData;

import com.petproject.shineexpert.entity.Services;
import com.petproject.shineexpert.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ServicesService servicesService;

    @Override
    public void run(String... args) throws Exception {

        Services complex = new Services();
        complex.setName("Complex washing");
        complex.setPrice("120");
        complex.setDescription("Complex washing: Washing your car and vacuum inside");

        Services basic = new Services();
        basic.setName("Basic washing");
        basic.setPrice("90");
        basic.setDescription("Basic washing");

        Services vacuuming = new Services();
        vacuuming.setName("Vacuum the interior");
        vacuuming.setPrice("30");
        vacuuming.setDescription("Vacuuming your interior");

        Services glassWashing = new Services();
        vacuuming.setName("Washing the glass inside");
        vacuuming.setPrice("15");
        vacuuming.setDescription("Washing glasses inside");

        Services engineWashing = new Services();
        vacuuming.setName("Engine washing");
        vacuuming.setPrice("70");
        vacuuming.setDescription("Washing engine");

        Services trunkCleaning = new Services();
        vacuuming.setName("Trunk cleaning");
        vacuuming.setPrice("30");
        vacuuming.setDescription("Clean all your trunk");

        Services polishing = new Services();
        vacuuming.setName("Nano-polishing");
        vacuuming.setPrice("70");
        vacuuming.setDescription("Modern polishing");




        servicesService.create(complex);
        servicesService.create(basic);
        servicesService.create(vacuuming);
        servicesService.create(glassWashing);
        servicesService.create(engineWashing);
        servicesService.create(trunkCleaning);
        servicesService.create(polishing);
    }
}

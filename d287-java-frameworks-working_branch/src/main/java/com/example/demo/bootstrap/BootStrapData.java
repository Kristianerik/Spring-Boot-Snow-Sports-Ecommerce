package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       if(partRepository.count() == 0) {
           OutsourcedPart burtonSnowboardBinding = new OutsourcedPart();
           burtonSnowboardBinding.setCompanyName("Burton");
           burtonSnowboardBinding.setName("Burton Snowboard Binding");
           burtonSnowboardBinding.setInv(5);
           burtonSnowboardBinding.setPrice(50.0);
           burtonSnowboardBinding.setId(10L);
           burtonSnowboardBinding.setMinimumInventory(1);
           burtonSnowboardBinding.setMaximumInventory(50);
           outsourcedPartRepository.save(burtonSnowboardBinding);
           OutsourcedPart thePart = null;
           List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
           for (OutsourcedPart part : outsourcedParts) {
               if (part.getName().equals("Burton Snowboard Binding")) thePart = part;
           }

           System.out.println(thePart.getCompanyName());

           InhousePart parkboardBase = new InhousePart();
           parkboardBase.setName("Park Snowboard Base");
           parkboardBase.setInv(5);
           parkboardBase.setPrice(100.0);
           parkboardBase.setId(20L);
           parkboardBase.setMinimumInventory(1);
           parkboardBase.setMaximumInventory(50);
           partRepository.save(parkboardBase);

           InhousePart backCountryBoardBase = new InhousePart();
           backCountryBoardBase.setName("Back Country Snowboard Base");
           backCountryBoardBase.setInv(5);
           backCountryBoardBase.setPrice(150.0);
           backCountryBoardBase.setId(30L);
           backCountryBoardBase.setMinimumInventory(1);
           backCountryBoardBase.setMaximumInventory(50);
           partRepository.save(backCountryBoardBase);

           InhousePart parkSkiBase = new InhousePart();
           parkSkiBase.setName("Park Ski Base");
           parkSkiBase.setInv(5);
           parkSkiBase.setPrice(100.0);
           parkSkiBase.setId(40L);
           parkSkiBase.setMinimumInventory(1);
           parkSkiBase.setMaximumInventory(50);
           partRepository.save(parkSkiBase);

           InhousePart skiBindings = new InhousePart();
           skiBindings.setName("Ski Bindings");
           skiBindings.setInv(5);
           skiBindings.setPrice(50.0);
           skiBindings.setId(50L);
           skiBindings.setMinimumInventory(1);
           skiBindings.setMaximumInventory(50);
           partRepository.save(skiBindings);
       }
        /*
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }
        */

        if(productRepository.count() == 0) {
            //adding products to repo
            Product burtonParkSnowboard = new Product("Burton Park Snowboard", 250.0, 15);
            Product burtonBackCountrySnowboard = new Product("Burton Back-Country Snowboard", 200.0, 15);
            Product k2CrossCountrySkis = new Product("K2 Cross-Country Skis", 300.0, 15);
            Product k2ParkSkis = new Product("K2 Park Skis", 200.0, 15);
            Product k2DownHillSkis = new Product("K2 Downhill Skis", 200.0, 15);
            productRepository.save(burtonParkSnowboard);
            productRepository.save(burtonBackCountrySnowboard);
            productRepository.save(k2CrossCountrySkis);
            productRepository.save(k2ParkSkis);
            productRepository.save(k2DownHillSkis);
        }


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

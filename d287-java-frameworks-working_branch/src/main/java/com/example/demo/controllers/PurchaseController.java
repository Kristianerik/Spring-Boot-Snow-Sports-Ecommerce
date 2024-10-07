package com.example.demo.controllers;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
public class PurchaseController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PartRepository partRepository;


    @PostMapping("/buyPart")
    public String buyPart(@RequestParam("partID") Long partID){
        Optional<Part> optionalPart = partRepository.findById(partID);

        if (optionalPart.isPresent()) {
            Part part = optionalPart.get();

            //Check if inv > 0
            if (part.getInv() > 0) {
                //reduce part count
                part.setInv(part.getInv() - 1);

                //save part to database
                partRepository.save(part);

                return "redirect:/purchaseSuccess";
            } else {
                return "redirect:/purchaseError";
            }

        }
        else {
            // Redirects to error if part not found
            return "redirect:/purchaseError";
        }
    }

    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam("productID") Long productID){
        Optional<Product> optionalProduct = productRepository.findById(productID);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            //Check if inv > 0
            if (product.getInv() > 0) {
                //reduce product count
                product.setInv(product.getInv() - 1);

                //save product to database
                productRepository.save(product);

                return "redirect:/purchaseSuccess";
            } else {
                return "redirect:/purchaseError";
            }

        }
        else {
            // Redirects to error if part not found
            return "redirect:/purchaseError";
        }
    }

    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess(){
        return "purchaseSuccess";
    }

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError";
    }
}

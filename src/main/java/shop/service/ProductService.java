package shop.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import shop.zasoby.Products;
import shop.zasoby.ProductsList;


public class ProductService {

	List<Products> productsList = ProductsList.getInstance();

    public List<Products> getAllEmployees() {       
        return productsList;
    }

    public List<Products> searchProductsByName(String name) {
        Comparator<Products> groupByComparator = Comparator.comparing(Products::getName)
                                                    .thenComparing(Products::getCategory);
        List<Products> result = productsList
                .stream()
                .filter(e -> e.getName().equalsIgnoreCase(name) || e.getCategory().equalsIgnoreCase(name))
                .sorted(groupByComparator)
                .collect(Collectors.toList());
        return result;
    }

    public Products getProducts(long id) throws Exception {
        Optional<Products> match
                = productsList.stream()
                .filter(e -> e.getId() == id)
                .findFirst();
        if (match.isPresent()) {
            return match.get();
        } else {
            throw new Exception("The Products id " + id + " not found");
        }
    }   

}

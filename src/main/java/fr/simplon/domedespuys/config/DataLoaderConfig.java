package fr.simplon.domedespuys.config;

import com.github.javafaker.Faker;
import fr.simplon.domedespuys.entity.*;
import fr.simplon.domedespuys.repository.*;
import fr.simplon.domedespuys.utils.Slugger;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {

    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private ImageRepository imageRepository;
    private PurchaseRepository purchaseRepository;
    private PurchaseProductRepository purchaseProductRepository;

    @Override
    public void run(String @NonNull ... args) {
        createUsers();
        createBrands();
        createAddresses();
        createProducts();
        createImages();
        createPurchases();
        createPurchaseProducts();
    }

    private void createUsers(){
        if(0 == userRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i<100; i++){
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());
                String email = user.getLastname()+"."+user.getFirstname()+"@"+faker.internet().domainName();
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                if(hasProbability(2,3)){
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0,5).getTime()).toLocalDate().atTime(0,0);
                user.setCreatedAt(localDate);
                userRepository.save(user);
            }
            userRepository.flush();
        }
    }

    private void createBrands(){
        if(0 == brandRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));
            Slugger slugger = new Slugger();
            for (int i = 0; i<50;i++){
                Brand brand = new Brand();
                brand.setLabel(faker.company().name());
                if(hasProbability(3,4)){
                    brand.setLogo(faker.company().logo());
                }
                brand.setSlug(slugger.slugify(brand.getLabel()));
                brandRepository.save(brand);
            }
            brandRepository.flush();
        }
    }

    public void createAddresses(){
        if(0 == addressRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i<150; i++){
                Address address = new Address();
                address.setLine(faker.address().streetAddress());
                if(hasProbability(2,3)){
                    address.setExtraLine(faker.address().buildingNumber());
                }
                address.setCity(faker.address().city());
                address.setZipCode(faker.address().zipCode());
                address.setCountry(faker.address().country());
                if(hasProbability(2,4)){
                    address.setPhone(faker.phoneNumber().phoneNumber());
                }
                address.setFirstname(faker.name().firstName());
                address.setLastname(faker.name().lastName());
                Random random = new Random();
                address.setUser(userRepository.findById(random.nextLong(1,100)).orElseThrow());
                int year = address.getUser().getCreatedAt().getYear();
                int currentYear = LocalDate.now().getYear();
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0,currentYear - year).getTime()).toLocalDate().atTime(0,0);
                address.setCreatedAt(localDate);
                addressRepository.save(address);
            }
            addressRepository.flush();
        }
    }

    private void createProducts(){
        if(0 == productRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));
            Random random = new Random();
            Slugger slugger = new Slugger();
            for(int i = 0; i<200; i++){
                Product product = new Product();
                if(hasProbability(2,4)){
                    product.setLabel(faker.book().title());
                    product.setPrice(random.nextLong(8000));
                    if(hasProbability(2,3)){
                        product.setDescription(faker.book().author()+" "+faker.book().genre());
                    }
                }else{
                    product.setLabel(faker.beer().name());
                    product.setPrice(random.nextLong(2000));
                    if(hasProbability(2,3)){
                        product.setDescription(faker.beer().style()+" "+faker.beer().malt());
                    }
                }
                product.setSlug(slugger.slugify(product.getLabel()));
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0,15).getTime()).toLocalDate().atTime(0,0);
                product.setCreatedAt(localDate);
                product.setBrand(brandRepository.findById(random.nextLong(1,50)).orElseThrow());
                productRepository.save(product);
            }
            productRepository.flush();
        }
    }

    private void createImages(){
        if(0 == imageRepository.count()){
            Random random = new Random();
            for(int i = 0; i<350; i++){
                Image image = new Image();
                Product product = productRepository.findById(random.nextLong(1, 200)).orElseThrow();
                image.setProduct(product);
                image.setDefault((long) product.getImages().size() == 0);
                ArrayList<String> extensions = new ArrayList<>(Arrays.asList("jpg","png","webp"));
                image.setExtension(extensions.get(random.nextInt(0, 2)));
                image.setPath("https://picsum.photos/500/500?r="+random.nextInt());
                imageRepository.save(image);
            }
            imageRepository.flush();
        }
    }

    private void createPurchases(){
        if(0 == purchaseRepository.count()){
            Faker faker = new Faker(Locale.of("fr"));
            Random random = new Random();
            for(int i = 0; i<350; i++){
                Purchase purchase = new Purchase();
                Address address = addressRepository.findById(random.nextLong(1, 150)).orElseThrow();
                purchase.setAddress(address);
                purchase.setUser(address.getUser());
                int year = address.getCreatedAt().getYear();
                int currentYear = LocalDate.now().getYear();
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0,currentYear - year).getTime()).toLocalDate().atTime(0,0);
                purchase.setCreatedAt(localDate);
                StringBuilder number = new StringBuilder();
                number.append('P');
                number.append(purchase.getCreatedAt().getYear());
                number.append(UUID.randomUUID());
                purchase.setNumber(number.toString().replaceAll("-","").substring(0,19));
                ArrayList<String> status = new ArrayList<>(Arrays.asList("pending","paid","shipped","delivered","cancelled"));
                purchase.setStatus(status.get(random.nextInt(0, 4)));
                purchaseRepository.save(purchase);
            }
            purchaseRepository.flush();
        }
    }

    private void createPurchaseProducts(){
        if(0 == purchaseProductRepository.count()){
            Random random = new Random();
            List<Purchase> purchases = purchaseRepository.findAll();
            for(Purchase purchase : purchases){
                PurchaseProduct purchaseProduct = new PurchaseProduct();
                purchaseProduct.setPurchase(purchase);
                purchaseProduct.setQuantity(random.nextInt(1,5));
                Product product = productRepository.findById(random.nextLong(1, 200)).orElseThrow();
                purchaseProduct.setProduct(product);
                purchaseProduct.setPrice(product.getPrice()*purchaseProduct.getQuantity());
                purchaseProductRepository.save(purchaseProduct);
            }
            purchaseProductRepository.flush();
        }
    }

    private boolean hasProbability(int expected, int max){
        Random random = new Random();
        return random.nextInt(max) < expected;
    }

}

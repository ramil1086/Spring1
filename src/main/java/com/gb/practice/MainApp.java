package com.gb.practice;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService productService = applicationContext.getBean(ProductService.class);
        Cart cart = applicationContext.getBean(Cart.class);
        productService.showInfo();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String[] cmd = br.readLine().split(" ");
                if (cmd[0].equals("exit")) break;
                else if (cmd[0].equals("new") && cmd[1].equals("cart")) {
                    System.out.println("Создаю новую корзину");
                    throw new NewCartException();
                }

                int id = Integer.parseInt(cmd[1]);
                Product product = productService.getProductById(id);
                if (cmd[0].equals("add")) {
                    cart.addProduct(product);
                    cart.printCart();
                }
                if (cmd[0].equals("remove")) {
                    cart.removeProduct(product);
                    cart.printCart();
                }
            }
            catch (NewCartException nce) {
                cart = applicationContext.getBean(Cart.class);
                productService.showInfo();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println("Команда:");
            }
        }
        br.close();
        applicationContext.close();
    }


}

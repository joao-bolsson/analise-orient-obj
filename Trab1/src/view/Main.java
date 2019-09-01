package view;

import controller.ProductController;
import controller.UserController;
import java.util.List;
import java.util.Scanner;
import model.ItemRequest;
import model.Product;
import model.Request;
import model.User;

/**
 *
 * @author João Bolsson (jvmarques@inf.ufsm.br)
 * @version 2019, Sep 01.
 */
public class Main {

    private final ProductController prodController = new ProductController();
    private final UserController userController = new UserController();

    public Main() {
    }

    private void init() {
        // Using Scanner for Getting Input from User
        Scanner in = new Scanner(System.in);

        String cmd = in.nextLine();

        do {
            System.out.println("Comandos:");
            System.out.println("[Q]  para sair");
            System.out.println("[+U] adicionar usuário");
            System.out.println("[-U] remover usuário");
            System.out.println("[+P] adicionar produto");
            System.out.println("[-P] remover produto");
            System.out.println("[+R] adicionar pedido");
            System.out.println("[-R] remover pedido");

            proccessCmd(cmd);

        } while (!cmd.equals("Q"));
    }

    private void proccessCmd(final String cmd) {
        switch (cmd) {
            case "+U":
                addUser();
                break;

            case "+P":
                addProduct();
                break;

            case "+R":
                addRequest();
                break;

        }
    }

    private void addRequest() {
        Scanner in = new Scanner(System.in);

        System.out.println("Escolha o usuário para o pedido:");

        List<User> users = userController.getList();
        for (User u : users) {
            System.out.println(u);
        }

        System.out.println("User's id: ");
        String id = in.nextLine();
        User user = userController.getUser(id);

        // TODO: adicionar opção para poder adicionar mais de 1 item por pedido
        System.out.println("Escolha o produto para o pedido:");

        List<Product> prods = prodController.getList();
        for (Product p : prods) {
            System.out.println(p);
        }

        System.out.println("Product's id: ");
        String name = in.nextLine();
        Product product = prodController.getProduct(name);

        System.out.println("Product's Qtd: ");
        int qtd = in.nextInt();

        ItemRequest item = new ItemRequest(product, qtd);

        Request request = new Request();
        request.addItem(item);

        user.add(request);
    }

    private void addProduct() {
        Scanner in = new Scanner(System.in);

        System.out.println("Product's name: ");
        String name = in.nextLine();

        System.out.println("Product's value: ");
        float value = in.nextFloat();

        prodController.add(new Product(name, value));
    }

    private void addUser() {
        Scanner in = new Scanner(System.in);

        System.out.println("User id: ");
        String id = in.nextLine();

        System.out.println("User email: ");
        String email = in.nextLine();

        User user = new User(id, email);
        userController.add(user);
    }

    public static void main(final String[] args) {
        Main main = new Main();
        main.init();
    }

}

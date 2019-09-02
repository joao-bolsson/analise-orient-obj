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

        String cmd = "";

        while (!cmd.equals("Q")) {
            System.out.println("--------Comandos:------");
            System.out.println("[Q]  para sair");
            System.out.println("[+U] adicionar usuário");
            System.out.println("[-U] remover usuário");
            System.out.println("[+P] adicionar produto");
            System.out.println("[-P] remover produto");
            System.out.println("[+R] adicionar pedido");
            System.out.println("[-R] remover pedido");

            System.out.print("Comando: ");
            cmd = in.nextLine();
            System.out.println("\n");
            proccessCmd(cmd);
        }
    }

    private void proccessCmd(final String cmd) {
        switch (cmd) {
            case "+U":
                addUser();
                break;

            case "-U":
                removeUser();
                break;

            case "+P":
                addProduct();
                break;

            case "-P":
                removeProduct();
                break;

            case "+R":
                addRequest();
                break;

            case "-R":
                removeRequest();
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

        Request request = new Request(user.getId() + "-" + user.getList().size());
        request.add(item);

        user.add(request);
    }

    private void removeRequest() {
        System.out.println("--Remover Pedido--");
        List<User> list = userController.getList();

        for (User u : list) {
            System.out.println("Pedidos do usuário " + u);
            List<Request> list1 = u.getList();
            for (Request r : list1) {
                System.out.println("----" + r);
            }
        }

        Scanner in = new Scanner(System.in);
        System.out.println("Request's id: ");
        in.nextLine();

    }

    private void addProduct() {
        Scanner in = new Scanner(System.in);

        System.out.println("Product's name: ");
        String name = in.nextLine();

        System.out.println("Product's value: ");
        float value = in.nextFloat();

        prodController.add(new Product(name, value));
    }

    private void removeProduct() {
        System.out.println("--Remover Produto--");
        System.out.println("Lista de Produtos:");
        List<Product> list = prodController.getList();
        for (Product p : list) {
            System.out.println(p);
        }

        Scanner in = new Scanner(System.in);

        System.out.println("Product's name: ");
        String name = in.nextLine();

        prodController.remove(prodController.getProduct(name));
    }

    private void addUser() {
        System.out.println("--Adicionar Usuário--");
        Scanner in = new Scanner(System.in);

        System.out.println("User's id: ");
        String id = in.nextLine();

        System.out.println("User's email: ");
        String email = in.nextLine();

        User user = new User(id, email);
        userController.add(user);
    }

    private void removeUser() {
        System.out.println("--Remover Usuário--");
        System.out.println("Lista de Usuários:");
        List<User> list = userController.getList();
        for (User u : list) {
            System.out.println(u);
        }

        Scanner in = new Scanner(System.in);

        System.out.println("User id: ");
        String id = in.nextLine();

        userController.remove(userController.getUser(id));
    }

    public static void main(final String[] args) {
        Main main = new Main();
        main.init();
    }

}

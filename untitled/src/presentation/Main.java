package presentation;

import metier.BanqueService;

public class Main {
    public static void main(String[] args) {
        BanqueService banqueService = new BanqueService();
        Menu menu = new Menu(banqueService);
        menu.afficherMenu();
    }
}

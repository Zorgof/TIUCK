package com.company.engine.scanner;

import com.company.engine.Board;
import com.company.engine.scanner.validation.ScannerValidation;
import com.company.engine.ship.Ship;
import com.company.engine.ship.ShipFactory;

import java.util.*;

public class ScannerUtil {

    private ShipFactory factory = new ShipFactory();


    public Board createBoard() {
        System.out.println("Statki");
        System.out.println("Wprowadz rozmiar siatki podaj dlugosc boku");
        return new Board(getValueBoardFromUser());
    }

    public List<Ship> getUserShipsList() {
        System.out.println("Dostepne statki do gry");
        System.out.println("0). Tankowiec");
        System.out.println("1). Krążownik");
        System.out.println("2). Żaglówka");
        System.out.println("Podaj ile chcesz wprowadzic statkow");

        Scanner scanner = new Scanner(System.in);
        int shipSize = -1;

        try {
            shipSize = scanner.nextInt();
            if (shipSize == 0) {
                throw new IllegalArgumentException();
            }
        } catch (InputMismatchException exeption) {
            System.out.println("To nie jest statek :)");
        } catch (IllegalArgumentException exception) {
            System.out.println("Cos za malo statkow");
        }

        System.out.println("Ktore chcesz te statki ?");
        return getUsersShip(shipSize);
    }

    private List<Ship> getUsersShip(int shipLength) {
        List<Ship> shipList = new ArrayList<>();

        do {
            try {
                Scanner scanner = new Scanner(System.in);
                shipList.add(factory.generateShip(scanner.nextInt()));

            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("Takiego statku jeszcze nie posiadamy ;)");
            }
        } while (shipList.size() != shipLength);
        return shipList;
    }

    private Integer getValueBoardFromUser() {
        Integer tempValue = null;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                tempValue = ScannerValidation.validateSizeBoard(scanner.nextInt());

            } catch (InputMismatchException | IllegalArgumentException exception) {
                System.out.println("Wprowadziłeś nieprawidoła wartość, spróbuj jeszcze raz");
            }
        } while (tempValue == null);
        return tempValue;
    }


}

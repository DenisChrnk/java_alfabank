package homework12;

import homework12.exceptions.BaggageTagPrintException;
import homework12.exceptions.FlightNotFoundException;
import homework12.exceptions.InvalidBaggageWeightException;
import homework12.exceptions.InvalidPassengerNameException;

import java.util.List;

public class BaggageDropDesk {
    private List<String> availableFlights;

    public BaggageDropDesk(List<String> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public BaggageTicket baggageDropOff(String passengerName, String flightNumber, int baggageWeight) {
        boolean flightCoincidence = false;
        for (String flight : availableFlights) {
            if (flight.equalsIgnoreCase(flightNumber)) {
                flightCoincidence = true;
            }
        }

        if (passengerName == null || passengerName.equals("")) {
            throw new InvalidPassengerNameException("Имя не может быть пустым или null");
        }
        if (baggageWeight < 0) {
            throw new InvalidBaggageWeightException("Вес багажа не может быть отрицательным");
        }
        if (!flightCoincidence) {
            throw new FlightNotFoundException("Рейс " + flightNumber + " в списке рейсов не найден");
        }
        if (flightNumber.equalsIgnoreCase("AE-404")) {
            throw new BaggageTagPrintException("Извините, у нас сломался принтер ");
        }

        System.out.println("Заплатите налог за корректные данные");

        return new BaggageTicket(passengerName, flightNumber, baggageWeight);
    }
}

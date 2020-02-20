package com.kodilla.fill;

import com.kodilla.fields.ShipSize;

import java.util.LinkedList;

public class FillCriterion {
    BoardFiller boardFiller = new BoardFiller();
    int shipCounts; // total ships counts - only in non-custom mode
    int fleetSize;
    int freeSea = boardFiller.getHorizontal() * boardFiller.getVertical();
    LinkedList<ShipSize> fleet = new LinkedList<ShipSize>();

    public int occupiedFleetSpace (ShipSize ship){
        freeSea = freeSea - fleetSize;
        return freeSea;
    }

    public LinkedList<ShipSize> addShip (ShipSize ship){
        fleet.add(ship);
        return fleet;
    }

    private int getFleetSize (LinkedList<ShipSize> tempFleet){
        int tempSize = 0;
        for (int i = 0; i < tempFleet.size(); i++){
            tempSize = tempSize + (tempFleet.get(i).getSizeUnit() * 2) + 2;
        }
        return tempSize;
    }


    // w późniejszej wersji delaruje, czy spełniony jesy wariant gry (teraz default)
    // - statki nie mogą się stytkać
    // - statki mogą być "nieliniowe"
    // - inne

}

package com.salesianostriana.dam.resteval;

import java.util.List;

public record PlaceDto(long id, List<Place> places ) {

    public static PlaceDto of (List<Place> items){
        return new PlaceDto(
                (long) items.size(),
                items
        );
    }


    public List<Place> to(){
        return places;
    }


}

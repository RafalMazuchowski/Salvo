package com.kodilla.boards;

import com.kodilla.fields.Field;

// służy do generowania tablic, które będą później ze sobą porównywane

public interface Board {
    Field[] board (int x, int y);
}

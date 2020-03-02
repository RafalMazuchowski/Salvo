package com.kodilla.boards;

import com.kodilla.fields.Field;
import jdk.nashorn.internal.ir.annotations.Ignore;

// służy do generowania tablic, które będą później ze sobą porównywane
@Ignore
public interface Board {
    Field[][] board ();
}

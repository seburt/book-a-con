package com.seburt.bookacon.core.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Room {

    ROOM_101 (0,101, 200),
    ROOM_102(1,102, 200),
    ROOM_201(2, 201, 130),
    ROOM_202(3, 202, 270);

    private final int roomIndex;
    private final int roomNumber;
    private final int capacity;

}

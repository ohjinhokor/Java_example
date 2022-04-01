package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSortedExample {

    public static void main(String[] args) {
        List<Room> rooms = Arrays.asList(new Room(1, "roomName1"), new Room(5, "roomName5"), new Room(2, "roomName2"));
        List<Room> sortedRoomList = rooms.stream()
//            .sorted((a, b) -> {
//                if (a.getRoomNumber() > b.getRoomNumber()) {
//                    return 1;
//                } else if(a.getRoomName() == b.getRoomName()){
//                    return 0;
//                }else {
//                    return -1;
//                }
            .sorted(Room::compareTo)
            .collect(Collectors.toList());

        for (Room room : sortedRoomList) {
            System.out.println(room.getRoomName());
        }
    }
}


class Room implements Comparable<Room> {

    private int roomNumber;
    private String roomName;

    public Room(int roomNumber, String roomName) {
        this.roomNumber = roomNumber;
        this.roomName = roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public int compareTo(Room targetRoom) {
        if (this.getRoomNumber() > targetRoom.getRoomNumber()) {
            return 1;
        } else if (this.getRoomName() == targetRoom.getRoomName()) {
            return 0;
        } else {
            return -1;
        }
    }
}

package com.company;

import java.util.Arrays;
import java.util.List;

public class EnumExample {

    public static void main(String[] args) {

        // Enum 클래스 사용 예시
        POWER[] values = POWER.values();
        for (POWER value : values) {
            System.out.println(value + ":" + value.getLevel() +":"+ value.getDescription());
        }

        // Enum안에 리스트를 넣고 리스트로 권한 여부 확인
        People newPeople = new People("이름", POWER.SECOND_POWER);
        if(newPeople.getPower().hasRole(Role.ROLE1)){
            System.out.println("ROLE1 가지고 있음");
        }

        if(newPeople.getPower().hasRole(Role.ROLE2)){
            System.out.println("ROLE2 가지고 있음");
        }

        if(newPeople.getPower().hasRole(Role.ROLE3)){
            System.out.println("ROLE3 가지고 있음");
        }


    }
}

// enum도 생성자를 사용하여 다양한 값을 넣어줄 수 있다.
enum POWER{
    FIRST_POWER(1, "1번째 권한", Arrays.asList(Role.ROLE1,Role.ROLE2))
    ,
    SECOND_POWER(2, "2번쨰 권한", Arrays.asList(Role.ROLE3, Role.ROLE4))
    ,
    THIRD_POWER(3, "3번쨰 권한", Arrays.asList(Role.ROLE5))
    ,
    LAST_POWER(4, "1번쨰 권한", Arrays.asList(Role.ROLE6))
    ;

    final private int level;

    final private String description;

    final private List<Role> roles;

    POWER(int level, String description, List<Role> roles){
        this.level = level;
        this.description = description;
        this.roles = roles;
    }

    public int getLevel(){
        return level;
    }

    public String getDescription(){
        return description;
    }

    public boolean hasRole(Role role){
        for (Role r : roles) {
            if(r == role){
                return true;
            }
        }
        return false;
    }
}

enum Role{
    ROLE1,
    ROLE2,
    ROLE3,
    ROLE4,
    ROLE5,
    ROLE6
}

class People{
    private String name;
    private POWER power;

    public People(String name, POWER power) {
        this.name = name;
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}
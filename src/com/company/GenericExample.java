package com.company;

public class GenericExample {

    public static void main(String[] args) {
        Book<String> book1 = new Book("name1", 1000);
        Book<Long> book2 = new Book("name2", 2000);

        book1.setGenericVariable("generic Variable Example");
        book2.setGenericVariable(70000L);

        //generic Method가 아닌 일반 메서드이기 때문에 매개변수 타입인 T 는 클래스에 붙은 T가 된다.
        System.out.println(book1.getGenericVariable());
        System.out.println(book2.getGenericVariable());

        //generic Method 사용
        Book.genericMethod(new BookChild("child name1", 1000, "nick name1"));
        Book.genericMethod(new BookChild("child name2", 2000, "nick name2"));

    }
}

class Book<T>{

   private String name;
   private int price;

   private T genericVariable;

   public T getGenericVariable(){
       return genericVariable;
   }

   // 제네릭 메서드의 T와 클래스 위에 붙어있는 T는 전혀 상관이 없음
   public static <T extends Book> void genericMethod(T genericMethodArg){
       System.out.println(genericMethodArg.getName());
   }

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGenericVariable(T genericVariable) {
        this.genericVariable = genericVariable;
    }
}

class BookChild extends Book{

    private String nickname;

    public BookChild(String name, int price, String nickname) {
        super(name, price);
        this.nickname = nickname;
    }
}

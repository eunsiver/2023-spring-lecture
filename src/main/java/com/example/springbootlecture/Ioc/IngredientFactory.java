package com.example.springbootlecture.Ioc;

public class IngredientFactory {
    public Ingredient getIngredient(String name){
        return switch (name) {
            case "치킨" -> new Chicken("국내산 치킨");
            case "스테이크" -> new Pork("국내산 돼지고기");
            default -> throw new RuntimeException("처리할 수 없는 메뉴가 없습니다.");
        };
    }
}

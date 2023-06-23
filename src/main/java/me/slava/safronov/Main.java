package me.slava.safronov;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main {
    public static void main(String[] args) {
        Stocks sber = new Stocks("sber", 35);
        Stocks vtb = new Stocks("vtb", -15);
        Stocks teboil = new Stocks("teboil", 12);
        Stocks tatoil = new Stocks("tatoil", -1);
        List<Stocks> stock = new ArrayList<>();
        stock.add(sber);
        stock.add(vtb);
        stock.add(tatoil);
        stock.add(teboil);

        System.out.println("Task 1");
        System.out.println(predicate.test(sber));
        System.out.println(predicate1.test(sber));
        System.out.println("Task 2");
        consumer.accept(sber);
        consumer1.accept("vtb");
        System.out.println("Task 3");
        System.out.println(function.apply(3.14));
        System.out.println(function1.apply(3.89));
        System.out.println("Task 4");
        System.out.println(supplier.get());
        System.out.println(getSupplier.get());

    }

    //Задание 1
    //Напишите реализации функционального интерфейса Predicate
    //, которые проверяют, является ли число положительным. Если число положительное,
    // то предикат должен возвращать true, в противном случае — false.Реализуйте Predicate в двух вариантах:
    //через анонимный класс, через лямбду.
    static Predicate<Stocks> predicate = new Predicate<Stocks>() {
        @Override
        public boolean test(Stocks stocks) {
            return stocks.getIncomeAndLossOfTheStock() >= 0;
        }
    };

    static Predicate<Stocks> predicate1 = stocks -> stocks.getIncomeAndLossOfTheStock() >= 0;

    //Задание 2
    //Создайте функциональный интерфейс Consumer
    //, который принимает на вход имя человека и выводит в консоль приветствие в его адрес.
    //Реализуйте его в двух вариантах: через анонимный класс и через лямбду.
    static Consumer<Stocks> consumer = new Consumer<Stocks>() {
        @Override
        public void accept(Stocks stocks) {
            System.out.println("hi " + stocks);
        }
    };
    static Consumer<String> consumer1 = stocks -> System.out.println("hi " + stocks);


    //Задание 3
    //Реализуйте функциональный интерфейс
    //Function, который принимает на вход вещественное число типа Double
    //, а возвращает его округленный вариант типа Long .
    //Реализуйте его в двух вариантах: через анонимный класс и через лямбду.
    static Function<Double, Long> function = new Function<Double, Long>() {
        @Override
        public Long apply(Double aDouble) {
            return aDouble.longValue();
        }
    };
    static Function<Double, Long> function1 = Double::longValue;


    //Задание 4
    //Напишите
    //Supplier, который возвращает случайное число из диапазона от 0 до 100.
    //Реализуйте его в двух вариантах: через анонимный класс и через лямбду.
    static Supplier<Integer> supplier = new Supplier<Integer>() {
        @Override
        public Integer get() {
            return (int) (Math.random() * 100);
        }
    };
    static Supplier<Integer> getSupplier = () -> (int) (Math.random() * 100);


    //Задание 5 (опциональное)
    //Теперь попрактикуемся в комбинировании нескольких функций в одну сложную конструкцию. Для примера построим следующую комбинацию.
    //Дан предикат condition и две функции: ifTrue и ifFalse. Напишите метод ternaryOperator
    //, который из предиката и двух функций построит новую функцию, возвращающую значение функции
    //ifTrue, если предикат выполнен, а в остальных случаях — ifFalse.
    //public static <T, U> Function<T, U> ternaryOperator(
    //   Predicate<? super T> condition,
    //   Function<? super T, ? extends U> ifTrue,
    //   Function<? super T, ? extends U> ifFalse) {
    //   ...
    //}

    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition, Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse) {
        return (x) -> condition.test(x) ? ifTrue.apply(x) : ifFalse.apply(x);
    }
}
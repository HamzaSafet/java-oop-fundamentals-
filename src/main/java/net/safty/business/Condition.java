package net.safty.business;

@FunctionalInterface
public interface Condition<T> {
    //hadi katsma interface fonctionnelle
    //interface fonctionnelle kaykon fiha un seul methode y"ni methode wahda
    //kanzido la notation (@FunctionalInterface) bach obligé 3lik dir methode wahda
    boolean test(T t);
}

package fr.simplon.domedespuys.service.interfaces;

public interface ICreatePurchaseProduct<T, P, D> {
    T create(P purchase, D dto);
}

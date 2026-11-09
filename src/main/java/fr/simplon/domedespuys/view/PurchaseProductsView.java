package fr.simplon.domedespuys.view;

public class PurchaseProductsView {
    public interface Id {}
    public interface Quantity {}
    public interface Price {}
    public interface Purchase {}
    public interface Product {}

    public interface PurchaseProductsViewList extends Quantity, Price, Product, ProductView.Label, ProductView.Price{}
}

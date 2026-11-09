package fr.simplon.domedespuys.view;

public class PurchaseView {
    public interface Id {}
    public interface Number {}
    public interface Status {}
    public interface CreatedAt {}
    public interface User {}
    public interface Address {}
    public interface PurchaseProducts {}

    public interface PurchaseViewList extends Id, Number, Status{}
    public interface PurchaseDetail extends Number, Status, Address, AddressView.AddressDetail, PurchaseProducts, PurchaseProductsView.PurchaseProductsViewList {}
}

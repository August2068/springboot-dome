package fr.simplon.domedespuys.view;

public class UserView {
    public interface Id {}
    public interface Email {}
    public interface Password {}
    public interface Firstname {}
    public interface Lastname {}
    public interface Phone {}
    public interface CreatedAt {}
    public interface Addresses {}
    public interface Purchases {}

    public interface UserViewList extends Id, Email {}
    public interface UserViewDetail extends Email, Firstname, Lastname, Phone, Addresses, AddressView.AddressViewList, Purchases, PurchaseView.PurchaseViewList {}
}

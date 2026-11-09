package fr.simplon.domedespuys.view;

public class AddressView {
    public interface Id {}
    public interface Line {}
    public interface ExtraLine {}
    public interface City {}
    public interface ZipCode {}
    public interface Country {}
    public interface Phone {}
    public interface Firstname {}
    public interface Lastname {}
    public interface CreatedAt {}
    public interface User {}

    public interface AddressViewList extends City, Line, Id {}
    public interface AddressDetail extends City, Line, ExtraLine, ZipCode, Country, Phone, Firstname, Lastname {}
}

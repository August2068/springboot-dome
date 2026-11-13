package fr.simplon.domedespuys.view;

public class ExceptionView {
    public interface Message {}
    public interface Status {}
    public interface Name {}

    public interface ExceptionViewList extends Message, Status, Name {}
}

package fr.simplon.domedespuys.view;

public class ProductView {
    public interface Id {}
    public interface Label {}
    public interface Description {}
    public interface Price {}
    public interface Slug {}
    public interface CreatedAt {}
    public interface Brand {}
    public interface Images {}
    public interface MainImage {}

    public interface ProductListView extends Id, Label, Price, Slug, MainImage, ImageView.Path{}
    public interface ProductDetailView extends ProductListView, Description, Brand, BrandView.BrandListView, Images, ImageView.Path, ImageView.IsDefault{}
    public interface ProductPostView extends Label, Description, Price, Slug, Brand, BrandView.BrandListView{}
}

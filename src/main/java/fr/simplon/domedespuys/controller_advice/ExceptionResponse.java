package fr.simplon.domedespuys.controller_advice;

import com.fasterxml.jackson.annotation.JsonView;
import fr.simplon.domedespuys.view.BrandView;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ExceptionResponse {
    @JsonView(BrandView.BrandDetailView.class)
    String message;
    @JsonView(BrandView.BrandDetailView.class)
    int status;
    @JsonView(BrandView.BrandDetailView.class)
    String name;
}

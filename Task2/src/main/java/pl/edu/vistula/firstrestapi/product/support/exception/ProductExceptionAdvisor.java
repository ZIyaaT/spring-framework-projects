package pl.edu.vistula.firstrestapi.product.support.exception;
import pl.edu.vistula.firstrestapi.product.shared.response.ErrorMessageResponse;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ProductExceptionAdvisor {

    private static final Logger log =
            LoggerFactory.getLogger(ProductExceptionAdvisor.class);

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageResponse ProductNotFound(ProductNotFoundException e) {
        log.error(e.getMessage(), e);
        return new ErrorMessageResponse(e .getLocalizedMessage());
    }
}

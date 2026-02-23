package kektor.innowise.trading.controller.ex;


import kektor.innowise.trading.client.ex.FinnhubException;
import kektor.innowise.trading.service.ex.CompanyFinancialsNotFound;
import kektor.innowise.trading.service.ex.NoCompaniesForExchange;
import kektor.innowise.trading.service.ex.NoMetricsForSymbol;
import kektor.innowise.trading.service.ex.NoTradeQuoteForSymbol;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FinnhubException.class)
    public ErrorResponse handleFinnhub(FinnhubException ex) {
        var ctx = ex.getContext();
        log.warn("Finnhub error: {}", ctx);
        HttpStatus status = Optional.ofNullable(HttpStatus.resolve(ctx.status()))
                .orElse(HttpStatus.INTERNAL_SERVER_ERROR);
        return ErrorResponse.builder(ex, status, ex.getMessage())
                .property("methodKey", ctx.methodKey())
                .property("httpMethod", ctx.httpMethod())
                .property("requestHeaders", ctx.requestHeaders().keySet())
                .property("responseHeaders", ctx.responseHeaders().keySet())
                .build();
    }

    @ExceptionHandler({
            CompanyFinancialsNotFound.class,
            NoCompaniesForExchange.class,
            NoMetricsForSymbol.class,
            NoTradeQuoteForSymbol.class
    })
    public ErrorResponse handleImageNotFound(Exception ex) {
        log.warn("Not found error: {}", ex.getMessage());
        return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleAll(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ErrorResponse.create(ex, HttpStatus.INTERNAL_SERVER_ERROR,
                Optional.ofNullable(ex.getMessage())
                        .orElse("Internal server error"));
    }

}

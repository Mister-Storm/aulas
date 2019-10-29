package br.com.spring.demo.entity;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

public class ConstraintAnot {

    @AssertFalse
    private boolean isUnsupported;

    @AssertTrue
    private boolean isActive;

    @DecimalMin("5.00")
    private BigDecimal valor;

    @DecimalMax("30.00")
    BigDecimal discount;

    @NotEmpty @NotNull
    @Min(16)
    private int idade;

    @Digits(integer=6, fraction=2)
    BigDecimal price;

    @Future
    private Date eventDate;

    @Past
    private Date dataPassada;

    @Pattern(regexp="(d{2})d{5}-d{4}")
    String phoneNumber;

    @Size(min=2, max=240)
    String brieMessage;
}

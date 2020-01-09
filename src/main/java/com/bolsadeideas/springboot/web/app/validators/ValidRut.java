package com.bolsadeideas.springboot.web.app.validators;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.bolsadeideas.springboot.web.app.models.Students;

@Documented
@Constraint(validatedBy = RutConstraintValidator.class)
@Target({ TYPE, FIELD, ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRut {

    String message() default "Invalid Rut";

    Class<?>[] groups() default {};

    Class<? extends Students>[] payload() default {};

}
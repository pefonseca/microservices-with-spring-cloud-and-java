package com.pefonseca.rest.with.spring.boot.and.java.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}

package com.example.demo.expections;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details ) {
}

package com.bridgelabz.indiancensus;

public class CensusAnalyserException extends Throwable {

	private String message;
    public ExceptionType type;

    enum ExceptionType {
        CENSUS_FILE_PROBLEM
    }

    public CensusAnalyserException(String message, ExceptionType type) {
        this.message = message;
        this.type = type;
    }
}

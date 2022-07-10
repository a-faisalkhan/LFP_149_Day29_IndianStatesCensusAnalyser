package com.bridgelabz.indiancensus;

import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IndiaCensusTest {

	private static final String INDIA_CENSUS_PATH_FILE = "D:\\Faisal\\Development\\EclipseWorkSpace\\Day29_LFP-149_IndianCensusAnalyser\\resources\\IndiaStateCensusData.csv";
	private static final String WRONG_CENSUS_PATH_FILE = "";
	private static final String TXT_CENSUS_PATH_FILE = "D:\\Faisal\\Development\\EclipseWorkSpace\\Day29_LFP-149_IndianCensusAnalyser\\resources\\IndiaStateCensus.txt";
	private static final String INDIA_STATE_CODE_PATH = "D:\\Faisal\\Development\\EclipseWorkSpace\\Day29_LFP-149_IndianCensusAnalyser\\resources\\IndiaStateCode.csv";

	// Given the States Census CSV file, Check to ensure the Number of Record
	// matches.
	@Test
	public void givenIndiaCensusCSVFile_WhenLoaded_ShouldReturnCorrectRecords() {
		IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
		try {
			int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_PATH_FILE);
			Assert.assertEquals(29, numOfRecord);
		} catch (CensusAnalyserException e) {

		}
	}

	// Given the State Census CSV file path incorrect, returns a custom exception.
	@Test
	public void givenIndiaCensusData_WithWrongFile_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(WRONG_CENSUS_PATH_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	// Given the State Census CSV file with incorrect type, Should throw exception.
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongType_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadIndiaCensusData(TXT_CENSUS_PATH_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	// Given the State Census CSV file with incorrect Delimiter, Should throw
	// exception.
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongDelimiter_ShouldThrowException() {
		IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
		try {
			int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_PATH_FILE);
			Assert.assertEquals(29, numOfRecord);
		} catch (Exception | CensusAnalyserException e) {
			System.out.println("State Census CSV file with incorrect Delimiter");
		}
	}

	// Given the State Census CSV file with incorrect ColumnName, Should throw
	// exception.
	@Test
	public void givenIndiaCensusCSVFile_WhenLoadedWithWrongColumn_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			int numOfRecord = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_PATH_FILE);
			Assert.assertEquals(29, numOfRecord);
		} catch (Exception | CensusAnalyserException e) {

		}
	}

	// Given the States Code CSV file, Check to ensure the Number of Record matches.
	@Test
	public void givenIndiaStateCodeCSVFile_WhenLoaded_ShouldReturnCorrectRecords() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			int numOfRecord = censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_PATH);
			Assert.assertEquals(37, numOfRecord);
		} catch (CensusAnalyserException e) {

		}
	}

	// Given the State Census CSV file incorrect, returns a custom exception.
	@Test
	public void givenIndiaStateCodeData_WithWrongFile_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadStateCodeData(WRONG_CENSUS_PATH_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	// Given the State Code CSV file with incorrect type, Should throw exception.
	@Test
	public void givenIndiaStateCodeCSVFile_WhenLoadedWithWrongType_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.loadStateCodeData(TXT_CENSUS_PATH_FILE);
		} catch (CensusAnalyserException e) {
			Assert.assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM, e.type);
		}
	}

	// Given the State Code CSV file with incorrect Delimiter, Should throw
	// exception.
	@Test
	public void givenIndiaStateCodeCSVFile_WhenLoadedWithWrongDelimiter_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			int numOfRecord = censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_PATH);
			Assert.assertEquals(36, numOfRecord);
		} catch (Exception | CensusAnalyserException e) {

		}
	}

	// Given the State Code CSV file with incorrect ColumnName, Should throw
	// exception.
	@Test
	public void givenIndiaStateCodeCSVFile_WhenLoadedWithWrongColumn_ShouldThrowException() {
		try {
			IndianCensusAnalyzer censusAnalyser = new IndianCensusAnalyzer();
			int numOfRecord = censusAnalyser.loadStateCodeData(INDIA_STATE_CODE_PATH);
			Assert.assertEquals(37, numOfRecord);
		} catch (Exception | CensusAnalyserException e) {

		}
	}
}

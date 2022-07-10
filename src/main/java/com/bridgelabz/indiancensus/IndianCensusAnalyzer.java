package com.bridgelabz.indiancensus;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class IndianCensusAnalyzer {

	static String path = "D:\\Faisal\\Development\\EclipseWorkSpace\\Day29_LFP-149_IndianCensusAnalyser\\resources\\IndiaStateCensusData.csv";
	public int loadIndiaCensusData(String path) throws CensusAnalyserException {

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));
			CsvToBeanBuilder<IndiaCensusCSV> csvCsvToBeanBuilder = new CsvToBeanBuilder<IndiaCensusCSV>(reader);
			csvCsvToBeanBuilder.withType(IndiaCensusCSV.class);
			csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<IndiaCensusCSV> csvToBean = csvCsvToBeanBuilder.build();
			Iterator<IndiaCensusCSV> censusCSVIterator = csvToBean.iterator();
			int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
			return numOfEntries;
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}
	}
	
	public int loadStateCodeData(String csvPath) throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvPath))) {
            CsvToBeanBuilder<IndianStateCodeCSV> csvCsvToBeanBuilder = new CsvToBeanBuilder<IndianStateCodeCSV>(reader);
            csvCsvToBeanBuilder.withType(IndianStateCodeCSV.class);
            csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IndianStateCodeCSV> csvToBean = csvCsvToBeanBuilder.build();
            Iterator<IndianStateCodeCSV> censusCSVIterator = csvToBean.iterator();
            int numOfEntries = 0;
			while (censusCSVIterator.hasNext()) {
				numOfEntries++;
				censusCSVIterator.next();
			}
            return numOfEntries;
        } catch (IOException e) {
            throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

	public static void main(String[] args) {
		System.out.println("******************Indian Census Analyzer******************");
		
		try {
			IndianCensusAnalyzer census = new IndianCensusAnalyzer();
			census.loadIndiaCensusData(path);
		} catch (CensusAnalyserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

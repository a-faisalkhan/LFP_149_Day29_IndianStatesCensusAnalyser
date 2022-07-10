package com.bridgelabz.indiancensus;

import com.opencsv.bean.CsvBindByName;

public class IndianStateCodeCSV {

	@CsvBindByName(column = "SrNo")
    private int srNo;

    @CsvBindByName(column = "State Name")
    private String state;

    @CsvBindByName(column = "TIN")
    private int tin;

    @CsvBindByName(column = "State Code")
    private String stateCode;

    @Override
    public String toString() {
        return "IndiaStateCodeCSV{" +
                "srNo=" + srNo +
                ", state='" + state + '\'' +
                ", tin=" + tin +
                ", stateCode='" + stateCode + '\'' +
                '}';
    }
}

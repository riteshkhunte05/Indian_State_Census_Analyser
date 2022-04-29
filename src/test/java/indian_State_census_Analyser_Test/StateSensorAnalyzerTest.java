package indian_State_census_Analyser_Test;

import org.junit.jupiter.api.Test;

import indian_state_census_Analyser.ReadOperations;
import indian_state_census_Analyser.StateSensorAnalysisException;
import junit.framework.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

		
		public class StateSensorAnalyzerTest {
		    ReadOperations readObj = new ReadOperations();
		    String fileName = "StateCensusData";


		    @Test
		    public void givenStateCensusCSVFileCorrect_EnsureNumberOfRecordsMatch() throws StateSensorAnalysisException {
		        String filePathRead = "E:\\StateCensusData.csv";
		        try {
		            int count = readObj.readDataCount(filePathRead, fileName);
		            Assert.assertEquals(29, count);
		        } catch (StateSensorAnalysisException e) {
		            e.printStackTrace();
		        }
		    }

		    
		    @Test
		    public void givenStateCensusCSVFile_WhenFileNameIncorrectShouldThrowException()  {
		        String filePathRead = "E:\\StateCensusData";

		        try {
		            int count = readObj.readDataCount(filePathRead, fileName);
		            Assert.assertEquals(29, count);
		        } catch (StateSensorAnalysisException e) {
		            e.printStackTrace();
		        }
		    }

		   
		    @Test
		    public void givenStateCensusCSVFile_WhenFileTypeIncorrectShouldThrowException()  {
		        String filePathRead = "E:\\StateCensusData.pdf";

		        try {
		            int count = readObj.readDataCount(filePathRead, fileName);
		            Assert.assertEquals(29, count);
		        }  catch (StateSensorAnalysisException e) {
		            e.printStackTrace();
		        }
		    }

		    
		    @Test
		    public void givenStateCensusCSVFileCorrect_ButDelimiterIncorrectShouldThrowException() {
		        String filePathRead = "E:\\StateCensusData.csv";
		        String delimiter = ".";
		        try {
		            if(delimiter.equals(","))
		                Assert.assertTrue(readObj.readDelimiter(filePathRead, delimiter));
		            else
		                Assert.assertFalse(readObj.readDelimiter(filePathRead, delimiter));
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }

		   
		    @Test
		    public void givenStateCensusCSVFileCorrect_ButHeaderIncorrectShouldThowException() {
		        List<String> stringName = new ArrayList<>();
		        String filePathRead = "E:\\StateCensusData.csv";
		        stringName.add("State");
		        stringName.add("Population");
		        stringName.add("AreaInSqKm");
		        stringName.add("Density");

		        try {
		            boolean flag = readObj.readHeader(filePathRead, stringName);
		            if(flag == true)
		                Assert.assertTrue(flag);
		            else
		                Assert.assertFalse(flag);
		        } catch (IOException | StateSensorAnalysisException e) {
		            e.printStackTrace();
		        }
		    }
		
	}



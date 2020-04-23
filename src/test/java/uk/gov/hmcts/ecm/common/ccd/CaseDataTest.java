package uk.gov.hmcts.ecm.common.ccd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class CaseDataTest {

    private CaseData caseData;

    @Before
    public void setUp() throws Exception {
        String json = "{"
                + " \"caseNotes\" : \"1111\", "
                + " \"positionType\" : \"Single\", "
                + " \"receiptDate\" : \"20 Jan 2019\", "
                + " \"userLocation\" : \"Bath\", "
                + " \"fileLocation\" : \"City\", "
                + " \"caseType\" : \"Single\", "
                + " \"feeGroupReference\" : \"1212\" "
                + "} ";
        ObjectMapper mapper = new ObjectMapper();
        caseData = mapper.readValue(json, CaseData.class);
    }


    @Test
    public void shouldCreateCaseDataFromJson() {
        assertThat(caseData.getCaseNotes(), is("1111"));
        assertThat(caseData.getPositionType(), is("Single"));
        assertThat(caseData.getReceiptDate(), is("20 Jan 2019"));
        assertThat(caseData.getUserLocation(), is("Bath"));
        assertThat(caseData.getFileLocation(), is("City"));
        assertThat(caseData.getCaseType(), is("Single"));
        assertThat(caseData.getFeeGroupReference(), is("1212"));
    }
}
package citrus.pojo;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "numberToDollarsResult"
})
@XmlRootElement(name = "NumberToDollarsResponse")
public class NumberToDollarsResponse {

    @XmlElement(name = "NumberToDollarsResult", required = true)
    protected String numberToDollarsResult;

    public String getNumberToDollarsResult() {
        return numberToDollarsResult;
    }

    public void setNumberToDollarsResult(String value) {
        this.numberToDollarsResult = value;
    }
}

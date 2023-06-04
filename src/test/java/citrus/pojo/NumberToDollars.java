package citrus.pojo;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "dNum"
})
@XmlRootElement(name = "NumberToDollars")
public class NumberToDollars {

    @XmlElement(required = true)
    protected BigDecimal dNum;

    public BigDecimal getDNum() {
        return dNum;
    }

    public void setDNum(BigDecimal value) {
        this.dNum = value;
    }
}

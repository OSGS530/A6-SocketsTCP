package E6.Protocol;

import java.util.ArrayList;
import java.util.List;

public class ProtocolRequest{
    private Integer operationType;
    private List<Double> params;

    public ProtocolRequest() {
    }

    public ProtocolRequest(Integer operationType, List<Double> params) {
        this.operationType = operationType;
        this.params = params;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public List<Double> getParams() {
        return params;
    }

    public void setParams(List<Double> params) {
        this.params = params;
    }
}
